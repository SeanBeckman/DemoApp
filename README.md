![geef](https://media.giphy.com/media/hWWwDj4MBurktacIvy/giphy.gif)

A simple app to demonstrate some of the principles of clean architecture. A basic separation of code into packages which would then eventually become their own contained module to ensure clean routing of data and responsibility separation between UI and logic.

Koin for DI with each layer responsible for for supplying instances of clesses and controlling access to it's APIs. Ideally these modules would contain mostly hidden classes with only the Use case and data objects available to the UI layer.

View models keep UI logic as separate from the Android APIs as possible allowing them to be so simple they can be unit tested. Live data is used for handling data flow between View Models, Android APIs and sub screens such as dialogs. RxJava is used for communicated to the Domain use cases and eventually back end or databases. Base classes are made to remove the boilerplate for screens that interact with a use case, both for state updating (loading, errors, success) as well as to ensure Rx observers are not leaking.

Recycler view uses a library in lieu of too short of time to implement a generic Adapter/view holder so as to remove that boiler plate. All someone implementing a list should care about is creating an item view model.

View is bound via data bindings, this keeps as much logic as possible in view models and not in the android API classes (fragment/activity). Live data supplies these bindings with values which can update when they do (even if there are currently no examples of this)

Despite the simplicity of this example, I unit tested as much as I saw fit to. UI tests would cover the escaped coverage that the view models could not cover (navigation for instance) but wasted 4+ hours trying to get OkHttp's mock web server to work so they are left a bit lacking.
