MyAndriodIKPMDApplication

Idea

For IKPMD I want to make a classic comic app, using the internet archive and various micro services. A hobby of mine was viewing comic books on mobile or tablet, only this is often difficult to get done easily and for free.

The app will consist of several Screens will consist of a home screen with strip search function, a strip detail screen where you can choose the chapter and an activity where you can read the strip and save it internally (the saved strip can be viewed in the favorites screen) Users are authorized data is stored in firebase. The goal is to make the app as accessible as possible, creating insightful visualization of data in an Android app, so the login screen is only an option.





To speed up possible teamwork in git, the branches are divided per use case, this has several advantages. Suppose I and one or more other person (s) are working on a position. We can create a feature branch and commit our code to it, then push it to GitHub. Periodically check for upstream commits on the feature bin and merge them locally. Once the feature is complete we have a nice history of all the work for it on one branch and it can be easily merged into the master branch.

1. Master
Most recently tested version of the app will be posted here.

2. DisplayComics
Provides an overview of book titles along with a picture of the cover.

3. fixBugFixGridview
I had tried to build the image loading myself, but once I finished it, the code wasn't efficient enough to work well on less powerful devices. On this branch I rewritten the application to work with Glide.

4. ComicDetails
Intended to display the chapters by a comic name.

5. PdfViewFromUrl
Means for the functionality that allows the user to view a comic in the app.