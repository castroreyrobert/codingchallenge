# MyCodingChallenge

# Objectives:
The goal of the task is to recreate our starting/core part of our app - the home screen. We are providing the response from our API, you have to display it.

## Data to be saved:
  1. Lists of the levels - This is used to restore the data when the user reopens the app
   
 ## Requirements:
  - Android version 24(Lollipop) - 34 (Android 14)
  
 ## Additional Information:
   1. MVVM Architecture - I used this architecture since this architecture enhances separation of concerns, it allows separating the user interface logic from the business (or the back-end) logic. 
   2. Repository pattern - I used this pattern in the model part since it decouples application from the data sources and testable business logic via Unit Tests
   3. Libraries:
      - Jetpack Library: Navigation, Coroutines, Room.
      - [Retrofit](https://square.github.io/retrofit/) for http requests.
      - [moshi](https://github.com/square/moshi) for Json library for Android.
      - [Glide](https://github.com/bumptech/glide)for loading image into the imageview.
    
