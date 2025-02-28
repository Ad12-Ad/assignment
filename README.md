# Pregnancy Vitals Tracker  

![Build Status](https://img.shields.io/badge/build-passing-brightgreen)
![Platform](https://img.shields.io/badge/platform-android-blue)
![API](https://img.shields.io/badge/API-24%2B%20(Recommended%2034)-orange)

Pregnancy Vitals Tracker is a comprehensive Android application designed to help expectant mothers monitor and manage their health by logging vital statistics. The app provides timely reminders and ensures data is securely stored for easy access and review.

## Features  

- **Vitals Logging**: Record essential health metrics such as blood pressure, heart rate, weight, and baby movements.  
- **Persistent Storage**: Securely save data using Room Database for future reference.  
- **Real-time Updates**: Immediate reflection of data changes through StateFlow.  
- **Reminder Notifications**: Receive periodic prompts to log vitals via WorkManager.  
- **Theming Support**: Seamless transition between light and dark modes to suit user preferences.  

## Tech Stack  

- **Language**: Kotlin  
- **UI Framework**: Jetpack Compose  
- **Architecture**: MVVM (Model-View-ViewModel)  
- **Database**: Room  
- **State Management**: StateFlow / LiveData  
- **Background Tasks**: WorkManager  
- **Dependency Injection**: Manual DI  

## Setup & Installation  

1. **Clone the Repository**:  
   ```bash
   git clone https://github.com/Ad12-Ad/assignment

2. **Open in Android Studio**: Launch Android Studio and open the cloned project.

3. **Sync Gradle:** Allow Gradle to sync and download necessary dependencies.

4. **Run the App:** Connect an Android device or start an emulator, then click on 'Run' to install the app.

    ```bash
    com.example.assignment
    ├── data
    │   ├── database        # Room Database and DAO
    │   ├── model           # Data Models
    │   └── repository      # Repository Layer
    ├── ui
    │   ├── screens         # Composable Screens and ViewModels
    │   ├── components      # Reusable UI Components
    │   └── theme           # Theming and Styling
    ├── worker
    │   ├── VitalsReminderWorker.kt   # Background Worker for Reminders
    │   └── VitalsNotificationService.kt # Notification Handling
    ├── di
    │   └── AppModule.kt    # Dependency Injection Setup
    ├── MainActivity.kt     # Main Entry Point
    └── PregnancyVitalsApp.kt # Application Class
    
## Screenshots  
<p align = "center" >
  
  <img src="https://github.com/user-attachments/assets/e13f2d84-9a05-4a64-bf0c-b901f620e0ec" width="30%" alt="SC1">
  <img src="https://github.com/user-attachments/assets/0eeab0bc-ee2c-4646-a6ca-ddc774f9887d" width="30%" alt="SC2">
  <img src="https://github.com/user-attachments/assets/09ede03b-9db6-4d0c-ae93-0ec9b0f27536" width="30%" alt="SC3">

</p>

---

## How Notifications Work  

- **Scheduled Reminders**: Utilizing WorkManager, the app schedules a task to prompt users every 5 hours to log their vitals.  
- **Direct Access**: Tapping on the notification directs the user to the vitals logging screen for convenience.
