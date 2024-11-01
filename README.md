<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<h1>WeatherApp 🌦️</h1>

<p><strong>WeatherApp</strong> is an Android application providing comprehensive weather forecast information. Developed using MVVM architecture and clean architecture principles, it leverages modern Android development tools, libraries, and offline data storage capabilities.</p>

<h2>Features 🛠️</h2>
<ul>
    <li><strong>Weather Forecast:</strong> Displays current and future weather data.</li>
    <li><strong>City List:</strong> Lists popular cities, allowing users to select and save their favorite cities.</li>
    <li><strong>Offline Support:</strong> Provides offline access to saved city weather information.</li>
</ul>

<h2>Modern Android Components</h2>
<ul>
    <li><strong>Network operations</strong> with Retrofit</li>
    <li><strong>Asynchronous data processing</strong> using Coroutines</li>
    <li><strong>Data management and UI updates</strong> with ViewModel and LiveData</li>
</ul>

<h2>Technologies Used 🧰</h2>
<ul>
    <li><strong>Kotlin:</strong> Main programming language</li>
    <li><strong>MVVM (Model-View-ViewModel):</strong> Core application architecture</li>
    <li><strong>Retrofit:</strong> API client for network requests</li>
    <li><strong>Coroutines:</strong> Asynchronous programming</li>
    <li><strong>ViewModel & LiveData:</strong> Data management and UI binding</li>
</ul>

<h2>Project Structure 📂</h2>
<p>The application follows a layered structure for clarity and maintainability. Here’s the project folder organization:</p>
<ul>
    <li><strong>Activity:</strong> Activities for the main screen and city list (CityListActivity, MainActivity)</li>
    <li><strong>Adapter:</strong> RecyclerView adapters (CityAdapter, ForecastAdapter)</li>
    <li><strong>Model:</strong> API response models (CityResponseApi, CurrentResponseApi, ForecastResponseApi)</li>
    <li><strong>Repository:</strong> Manages data sources (CityRepository, WeatherRepository) and handles Room integration for offline support</li>
    <li><strong>Server:</strong> Retrofit API client and service configurations (ApiClient, ApiServices)</li>
    <li><strong>ViewModel:</strong> Manages application logic (CityViewModel, WeatherViewModel)</li>
</ul>

<h2>Installation 🚀</h2>
<ol>
    <li>Clone this project to your local environment:
        <pre><code>git clone https://github.com/baristuzemenn/WeatherApp.git</code></pre>
    </li>
    <li>Open the project in Android Studio and load dependencies.</li>
    <li>Add your API key to the <code>ApiClient.kt</code> file.</li>
</ol>

<h2>API Key Acquisition 🌐</h2>
<p>The app uses the OpenWeatherMap API for weather data. To get an API key:</p>
<ol>
    <li>Visit the <a href="https://openweathermap.org/" target="_blank">OpenWeatherMap website</a>.</li>
    <li>Create a free account and log in.</li>
    <li>Copy your API key from your profile and add it to the <code>ApiClient.kt</code> file.</li>
</ol>

<h2>Screenshots 📸</h2>
<div style="display: flex; justify-content: space-around;">
    <img src="https://github.com/baristuzemenn/WeatherApp/raw/main/Ekran%20Resmi%202024-11-01%2001.58.10.png" alt="Main Screen Screenshot" width="250">
    <img src="https://github.com/baristuzemenn/WeatherApp/raw/main/Ekran%20Resmi%202024-11-01%2001.58.59.png" alt="City List Screenshot" width="250">
</div>

<h2>Contributing 🤝</h2>
<p>To contribute, feel free to add new features or fix bugs. Fork the project and submit a pull request with your changes.</p>

</body>
</html>
