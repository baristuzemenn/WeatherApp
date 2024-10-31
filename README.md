WeatherApp 🌦️

WeatherApp, hava durumu tahmin bilgilerini sunan bir Android uygulamasıdır. Bu proje, MVVM yapısıyla geliştirilmiş olup, modern Android geliştirme araçları ve kütüphaneleri kullanılarak temiz mimariye uygun şekilde tasarlanmıştır.
Özellikler 🛠️

Hava Durumu Tahmini: Anlık ve gelecek hava durumu verilerini sağlar.
Şehir Listesi: Popüler şehirler listelenir ve kullanıcı favori şehrini seçebilir.
Veri Depolama: Room veritabanı ile veri depolama özelliği.
Modern Android Bileşenleri

Retrofit ile ağ işlemleri
Coroutine ile asenkron veri işlemleri
ViewModel ve LiveData ile veri yönetimi ve UI güncellemeleri
Kullanılan Teknolojiler 🧰

Kotlin: Android uygulama geliştirme dili
MVVM (Model-View-ViewModel): Uygulama mimarisi
Retrofit: API istemcisi
Room: Lokal veri depolama
Coroutines: Asenkron programlama
ViewModel & LiveData: UI ile veri akışını yönetme
Proje Yapısı 📂

Uygulama, katmanlı bir yapı ile geliştirilmiştir. İşte proje klasör yapısı:
Activity: Uygulamanın ana ekran ve şehir listesi için aktiviteler (CityListActivity, MainActivity)
Adapter: RecyclerView adapter'leri (CityAdapter, ForecastAdapter)
Model: API response modelleri (CityResponseApi, CurrentResponseApi, ForecastResponseApi)
Repository: Veri kaynakları yönetimi (CityRepository, WeatherRepository)
Server: Retrofit API istemcisi ve servisleri (ApiClient, ApiServices)
ViewModel: Uygulama mantığını yöneten ViewModel sınıfları (CityViewModel, WeatherViewModel)
Kurulum 🚀

Bu projeyi yerel ortamınıza klonlayın:
bash
Kodu kopyala
git clone https://github.com/baristuzemenn/WeatherApp.git
Projeyi Android Studio ile açın ve bağımlılıkları yükleyin.
API anahtarınızı ApiClient.kt dosyasına eklemeyi unutmayın.
API Anahtarı Alımı 🌐

Bu uygulama, hava durumu verilerini almak için OpenWeatherMap API'sini kullanmaktadır. API anahtarınızı almak için aşağıdaki adımları izleyin:
OpenWeatherMap web sitesine gidin.
Ücretsiz bir hesap oluşturun.
Hesabınıza giriş yaptıktan sonra API anahtarınızı profilinizden kopyalayın.
API anahtarınızı ApiClient.kt dosyasına ekleyin.
Ekran Görüntüleri 📸

(Not: Ekran görüntüleri buraya eklenebilir.)
Katkı Sağlama 🤝

Bu projeyi geliştirirken yeni özellikler eklemek veya hataları düzeltmek için katkıda bulunabilirsiniz. Bir fork oluşturun ve pull request açarak değişikliklerinizi sunabilirsiniz.
