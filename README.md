I've used a lot of the common libraries used modern android develop to achieve an app that does efficient network calls with the use of Retrofit and OkHttp and Picasso from image loading. The JSON responses are converted with Moshi to data objects. Data objects are cached in a Room Persistence Library database to save on network calls for the slow internet connection. The app reloads from the database upon moving backwards to the previous view so memory can freed up but the state saved somewhat. I've also kept the calls to DB and network asynchronous through the use of RxJava. I've also followed the MVP pattern and feature based packaging structure.

The project is also minified to reduce it's size from 3.5MB to 1.8MB as I presumed from the requirements a target device with low memory wanted to keep the APK size low.

Premium requirements:
*	The app should have a nice look and feel.
*	Themed with Scottish Power font (Dialog Light) and 2/3 of the SP colours(Not exact matches but similar taken from https://www.materialui.co/colors)
*	The albums should be sorted by title.
*	The thumbnails should be sorted by URL.

List of recommended future improvements in the app.

* Adding and Uploading albums and pictures (if it were a real service) left the skeleton of this in codebase including a FAB (Non-functional) to add the album/photos
*	Tests both unit and integration if I had more time.
*	Caching image to save on more network calls.

