# Medical App


**Main Libraries used**

* [Rx Java](https://github.com/ReactiveX/RxJava/) For reactive programming
* [Dagger](https://google.github.io/dagger/) For implementing dependency injection
* [Django](https://www.djangoproject.com/) For developing the entire Backend APIs
* [Room](https://developer.android.com/topic/libraries/architecture/room.html) For persisting the data to provide base of offline first architecture
* [Live Data](https://developer.android.com/topic/libraries/architecture/livedata.html) For handling the reactive side on the view layer. I could have used RxJava here as well, however Activity lifecycle management of Live Data is just awesome.

# Android App Architecture(Offline First)
I have derived inspirations from the official guide of [Android Architecture](https://developer.android.com/topic/libraries/architecture/index.html). I have made some tweaks to this architecture to suit our needs.

**View Model**
View Models are extremely powerful and useful entities. I have used them to to abstract away the data handling part from the Views. As and when the data gets updated, it informs the UI via [LiveData](https://developer.android.com/topic/libraries/architecture/livedata.html)
The only and only task of View Model is to provide data to the View layer.

**Data Source**
Data Source abstract away the complications of fetching data from different resources (API/Local). The only task of Data Source is to get Data from the API, save it in local DB and return the observer of Local DB to View Model.

**Note: In a way, View Models are just observing the changes made to the Local DB. It never directly makes a request to the API Server. As and when the local DB gets updated, it gets notified and hence notifies the UI. This increases the responsiveness tremendously.**

This gives rise to the talk of the town architecture - **Offline First**
![Android Architecture](https://developer.android.com/topic/libraries/architecture/images/final-architecture.png)

Ref:[https://developer.android.com/](https://developer.android.com/)

I have tweaked the above architecture a bit. Instead of confusing the repository layer I have asked it to take data only and only from DB and return it straighaway. After which, make a call to API, update the DB and then inform the UI.

**Network**
This is a common Module which is used to make API calls to the server. I have used [Retrofit](http://square.github.io/retrofit/) to make API calls.

**Disc Data**
This provides interface to read data fromo Local DB. I have used [Room](https://developer.android.com/topic/libraries/architecture/room.html) as an ORM to SQLite. I have used GreenDAO before to achieve this before, tried out Room for the first time. Extremely easy to use. 

**DI**
I have used Dagger to manage the entire Dependency injection. Without DI things would have gone wayward. It helped in preparing a well architected, a well testable app. Due to time constraints I was not able to write test cases, however the architecture is such that writing test cases would be pretty easy.

**RXJava**
Last but not the least, infact the most important part of the app - **RX** RXJava proved intrumental(Looks like I have just finished a Play and I am giving credentials to all the libraries :P) in achieving the offline first Architecture.

As they say 'Build and app like there is not network'. I wanted something which could observe the changes in the DB, that's where RXJava became extremely useful.

Apart from observing the changes made to DB, it also helped in chaining up events right from clicking of button to receiving response.


