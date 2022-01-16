# android-project-template
A template project with basic folder structure to start a new Android Project

## Demo
<img src="https://github.com/islamdidarmd/android-project-template/blob/master/s1.png" width="200" height="400" /> <img src="https://github.com/islamdidarmd/android-project-template/blob/master/s2.jpg" width="200" height="400" />


## Functionality
1. Finds repositories from github from given keyword

## Architecture
Project is written by following `Clean Code Architecture`
### Directory Structure
#### App
1. `app/src/main/java/com.example.androidprojecttemplate/data` contains the `data` layer
2. `app/src/main/java/com.example.androidprojecttemplate/domain` contains the `domain` layer
3. `app/src/main/java/com.example.androidprojecttemplate/presentation` contains the `presentation` layer
4. `app/src/main/java/com.example.androidprojecttemplate/di` contains the `modules` for `dependency injection`
5. `app/src/test/java/com.example.androidprojecttemplat` contsins the `unit tests`

## Technology Used
1. `Kotlin` programming language to write the app
2. `Jetpack Compose` for building UI
3. `Koin` for `Dependency Injection`
4. `Retrofit` and `OkHttp` for networking
5. `Moshi` for serialization
6. `Mockk` for mocking in tests

## Getting Started
1. Download or Clone the repository
2. Unzip downloaded file (if downloaded)
3. Open the project in `Android Studio`. This project is developed in `Android Studio Arctic Fox 2020.3.1 Patch 4`
4. Run the `app`
