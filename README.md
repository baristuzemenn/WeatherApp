WeatherApp 🌦️

WeatherApp is an Android application that provides weather forecast information. This project is developed using the MVVM architecture and designed in accordance with clean architecture principles using modern Android development tools and libraries.
Features 🛠️

Weather Forecast: Provides current and future weather data.
City List: Lists popular cities, allowing users to select their favorite city.
Data Storage: Utilizes Room database for data storage.
Modern Android Components

Network operations with Retrofit
Asynchronous data processing with Coroutines
Data management and UI updates with ViewModel and LiveData


Technologies Used 🧰

Kotlin: The programming language for Android application development
MVVM (Model-View-ViewModel): Application architecture
Retrofit: API client
Room: Local data storage
Coroutines: Asynchronous programming
ViewModel & LiveData: Managing data flow with the UI


Project Structure 📂

The application is developed with a layered architecture. Here’s the project folder structure:
Activity: Activities for the main screen and city list (CityListActivity, MainActivity)
Adapter: RecyclerView adapters (CityAdapter, ForecastAdapter)
Model: API response models (CityResponseApi, CurrentResponseApi, ForecastResponseApi)
Repository: Data source management (CityRepository, WeatherRepository)
Server: Retrofit API client and services (ApiClient, ApiServices)
ViewModel: ViewModel classes managing application logic (CityViewModel, WeatherViewModel)


Installation 🚀

Clone this project to your local environment:
bash
Kodu kopyala
git clone https://github.com/baristuzemenn/WeatherApp.git
Open the project in Android Studio and load the dependencies. Don’t forget to add your API key to the ApiClient.kt file.
API Key Acquisition 🌐

This application uses the OpenWeatherMap API to retrieve weather data. To obtain your API key, follow these steps:
Visit the OpenWeatherMap website.
Create a free account.
After logging in, copy your API key from your profile.
Add your API key to the ApiClient.kt file.
Screenshots 📸

<div style="display: flex; justify-content: space-around;"> <img src="https://github.com/baristuzemenn/WeatherApp/raw/main/Ekran%20Resmi%202024-11-01%2001.58.10.png" alt="Main Screen Screenshot" width="250" /> <img src="https://github.com/baristuzemenn/WeatherApp/raw/main/Ekran%20Resmi%202024-11-01%2001.58.59.png" alt="City List Screenshot" width="250" /> </div>


Contributing 🤝

You can contribute to this project by adding new features or fixing bugs. Create a fork and submit your changes via a pull request.
