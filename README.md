# ABSA task

Below are the requirements for the task:

Please create a simple Android app that uses the Numbers API (http://numbersapi.com/).
The app should allow the user to get a fact on a random number as well as have the ability and search for a fact about a specific date, The app should cover the following criteria:

    Be written in Kotlin
    Use of constraint layouts
    Follow the MVVM pattern

## APK

Grab one from here (https://github.com/gatanga/absa-task/blob/main/app/build/outputs/apk/debug/app-debug.apk) or just build

## Features in the app

* On the Trivia page:
    * You can generate a random number and get a fact about that number. The random number is between 0 and 100. I noticed fewer facts on numbers greater than a 100.
    * The Trivia page also has an input field where you can enter your own number and get a fact about that number.
    * Please note that a number can have multiple facts. Hence, after randomly generating a number or entering a number in the textfield, you can get different facts after pressing the "Search" button repetitively.
* On the date page:
    *  You can use a normal date picker (more info here: https://m2.material.io/components/date-pickers/android) to pick a day and month. The year is ignored.
    *  After pressing search, you get a fact about that date.
    *  Please note that a date can have multiple facts. Hence, after choosing a date, you can get different facts after pressing the "Search" button repetitively.
* Trivia and Date are part of a viewpager2 (with a TabLayout)

## How to build the project

#### Requirements

* Get Java JDK (You can use the Oracle JDK or the OpenJDK one). Download JDK 11 or above.
    * Add the JDK to your path
    * Set the JAVA_HOME value in the environment. For Unix and Linux based OS, you can use the
      command "whereis java". Mine is in **/usr/bin/JAVA**. You can then set it using **export
      JAVA_HOME=/usr/bin/JAVA**. On my Mac, I add add *export JAVA_HOME=/usr/bin/JAVA* to *~
      /.bash_profile* and then do *source ~/.bash_profile*  to have **JAVA_HOME** added permanently
      to the path.
* Android Studio (Download one from here: https://developer.android.com/studio).

#### Checkout the project

You can use `git clone https://github.com/gatanga/absa-task.git` to check out the project
or use a git based UI app like https://www.sourcetreeapp.com/ or https://desktop.github.com/

#### Building the project

1. Open Android studio
2. Click on "Import project" or "Open Project" as seen in these screenshots
   below:
   ![](https://link.storjshare.io/jvog7fzm3omr53jpvuqwiegfbx6a/absa%2FScreenshot%202022-12-07%20at%2004.09.15.png?download=1)
   or
   ![](https://link.storjshare.io/juicol5q5nhlak2n5ovphdgnka4a/absa%2FScreenshot%202022-12-07%20at%2004.15.35.png?download=1)
   or
   ![](https://link.storjshare.io/jvfwjk6bsllesi6jgdic35xyjhra/absa%2FScreenshot%202022-12-07%20at%2004.15.47.png?download=1)
3. If you don't already have build and compile tools, Android Studio will need to download those
   tools which might take some time.
4. Project gradle syncing -- This process is quite lengthy, so you might want to go grab a cup of
   coffee/tea/beer if it's beer Friday :joy:
5. Android Studio might default to a JDK lower than 11 (I think depending on what version of Android Studio you are using). In this case, you can select the JDK >=11 by going to:
   **Android Studio Preferences** *->* **Build, Execution, Deployment** *->* **Build Tools** *->* **
   Gradle** -> Select the Gradle JDK in the window on the right. Please see image
   below: ![](https://link.storjshare.io/jvomj563z3h3axkyan73czrwg6fa/absa%2FScreenshot%202022-12-07%20at%2004.25.41.png?download=1)

6. Android Studio will sync again.
7. Run the the app:


## Tech stark

* Kotlin DSL for gradle management
* Android Studio for IDE
* Kotlin for coding language
* MVVM for design pattern
* XML layouts instead of Jetpack Compose
* Architecture components
* Android Hilt for dependency injection
* Retrofit for RESTful calls
* Coroutines for thread management
* LiveData for communication between ViewModels and android views (Fragments and Activities)
* Flow for communication between non Android context components

## Project architecture

* I decided to organize the project in a modular way.
    * The actuall design pattern as per request is MVVM.
    * But underneath, I created the `app(ui)`, `domain`, `data` and `models` modules. My experience is that this allows different teams to work independently without so much confliction.
        *  The `models` module is a standard `kotlin` library module.
        *  The `data` and `domain` modules are `Android Library` modules. This should not be the case though. They deal with backend work/interacting and should definitely be `kotlin-library` modules instead.
           However, because I was using Hilt for dependency injection in Android modules, I did not want to use a second library for DI in these modules. This is because Hilt is not supported in non Android modules.
* Please don't pay much attention to the UI.
    * Definitely needs a redesign
    * I did not focus on it and would be happy to build a proper UI.
    * You will notice there are no progress indicators :):
* Also, I have a small coverage of unit tests. I know that traditionally, we should write unit
  tests first.
* I am happy to have 100% coverage + UI tests later.