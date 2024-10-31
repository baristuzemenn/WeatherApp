package com.baristuzemen.weatherapp.Activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.baristuzemen.weatherapp.Adapter.ForecastAdapter
import com.baristuzemen.weatherapp.Model.CurrentResponseApi
import com.baristuzemen.weatherapp.Model.ForecastResponseApi
import com.baristuzemen.weatherapp.R
import com.baristuzemen.weatherapp.ViewModel.WeatherViewModel
import com.baristuzemen.weatherapp.databinding.ActivityMainBinding
import com.github.matteobattilana.weather.PrecipType
import eightbitlab.com.blurview.RenderScriptBlur
import retrofit2.Call
import retrofit2.Response
import java.util.Calendar
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding
    private val weatherViewModel: WeatherViewModel by viewModels()
    private val calender by lazy { Calendar.getInstance() }

    private val forecastAdapter by lazy { ForecastAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.apply {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            statusBarColor = Color.TRANSPARENT
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        }


        binding.apply {

            var lat = intent.getDoubleExtra("lat", 0.0)
            var lon = intent.getDoubleExtra("lon", 0.0)
            var name = intent.getStringExtra("name")

            if (lat == 0.0) {
                lat = 38.42
                lon = 27.14
                name = "İzmir"
            }

            mainActivityAddCityButton.setOnClickListener{
                startActivity(Intent(this@MainActivity,CityListActivity::class.java))

            }



            mainActivityCityTextView.text = name
            mainActivityProgressBar.visibility = View.VISIBLE
            weatherViewModel.loadCurrentWeatherData(lat, lon, "metric").enqueue(object :
                retrofit2.Callback<CurrentResponseApi> {
                override fun onResponse(
                    call: Call<CurrentResponseApi>,
                    response: Response<CurrentResponseApi>
                ) {
                    if (response.isSuccessful) {
                        val data = response.body()
                        mainActivityProgressBar.visibility = View.GONE
                        mainActivityDetailLinearLayout.visibility = View.VISIBLE
                        data?.let {
                            mainActivityStatusTextView.text = it.weather?.get(0)?.main ?: "-"
                            mainActivityWindTextView.text =
                                it.wind?.speed?.let { Math.round(it).toString() } + "Km/h"
                            mainActivityHumidityTextView.text = it.main?.humidity?.toString() + "%"
                            mainActivityCurrentTempTextView.text =
                                it.main?.temp?.let { Math.round(it).toString() } + "°"
                            mainActivityMaxTempTextView.text =
                                it.main?.tempMax?.let { Math.round(it).toString() } + "°"
                            mainActivityMinTempTextView.text =
                                it.main?.tempMin?.let { Math.round(it).toString() } + "°"

                            val drawable = if (isNightNow()) R.drawable.night_bg
                            else {

                                setDynamicallyWallpaper(it.weather?.get(0)?.icon ?: "-")

                            }

                            mainActivityBackgroundImageView.setImageResource(drawable)
                            setEffectRainSnow(it.weather?.get(0)?.icon ?: "-")
                        }

                    }

                }

                override fun onFailure(call: Call<CurrentResponseApi>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.toString(), Toast.LENGTH_SHORT).show()
                }

            })


            var radius = 10f
            val decorView = window.decorView
            val rootView = (decorView.findViewById(android.R.id.content) as ViewGroup?)
            val windowBackground = decorView.background

            rootView?.let {
                mainActivityForecastBlurView.setupWith(it, RenderScriptBlur(this@MainActivity))
                    .setFrameClearDrawable(windowBackground)
                    .setBlurRadius(radius)
                mainActivityForecastBlurView.outlineProvider = ViewOutlineProvider.BACKGROUND
                mainActivityForecastBlurView.clipToOutline = true
            }

            weatherViewModel.loadForecastWeatherData(lat, lon, "metric")
                .enqueue(object : retrofit2.Callback<ForecastResponseApi> {
                    override fun onResponse(
                        call: Call<ForecastResponseApi>,
                        response: Response<ForecastResponseApi>
                    ) {
                        if (response.isSuccessful) {
                            val data = response.body()
                            mainActivityForecastBlurView.visibility = View.VISIBLE

                            data?.let {
                                forecastAdapter.differ.submitList(it.list)
                                mainActivityForecastRecyclerView.apply {
                                    layoutManager = LinearLayoutManager(
                                        this@MainActivity,
                                        LinearLayoutManager.HORIZONTAL,
                                        false
                                    )
                                    adapter = forecastAdapter
                                }
                            }
                        }
                    }

                    override fun onFailure(call: Call<ForecastResponseApi>, t: Throwable) {
                        TODO("Not yet implemented")
                    }

                })


        }

    }

    private fun isNightNow(): Boolean {
        return calender.get(Calendar.HOUR_OF_DAY) >= 18
    }

    private fun setDynamicallyWallpaper(icon: String): Int {
        return when (icon.dropLast((1))) {
            "01" -> {
                initWeatherView(PrecipType.CLEAR)
                R.drawable.snow_bg
            }

            "02", "03", "04" -> {
                initWeatherView(PrecipType.CLEAR)
                R.drawable.cloudy_bg
            }

            "09", "10", "11" -> {
                initWeatherView(PrecipType.RAIN)
                R.drawable.rainy_bg
            }

            "13" -> {
                initWeatherView(PrecipType.SNOW)
                R.drawable.snow_bg
            }

            "50" -> {
                initWeatherView(PrecipType.CLEAR)
                R.drawable.haze_bg
            }

            else -> 0

        }
    }

    private fun setEffectRainSnow(icon: String) {
        when (icon.dropLast((1))) {
            "01" -> {
                initWeatherView(PrecipType.CLEAR)
            }

            "02", "03", "04" -> {
                initWeatherView(PrecipType.CLEAR)
            }

            "09", "10", "11" -> {
                initWeatherView(PrecipType.RAIN)
            }

            "13" -> {
                initWeatherView(PrecipType.SNOW)
            }

            "50" -> {
                initWeatherView(PrecipType.CLEAR)
            }

        }
    }


    private fun initWeatherView(type: PrecipType) {
        binding.mainActivityWeatherView.apply {
            setWeatherData(type)
            angle = -20
            emissionRate = 100.0f
        }
    }
}