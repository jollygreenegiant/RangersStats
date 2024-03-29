## Description
Rangers Stats is a simple app that displays some information about the greatest sports team in history, the New York Rangers.  It will show their next game, information about each player, and some basic stats about their upcoming game.

## Things to note
1. The NHL API is an absolute wreck and is completely undocumented, so try not to look at my data classes too closely - I'm as grumpy about them having to look like that as you are.  There are so many types that have *very* similar but not quite exactly the same shapes, and often the fields will be named differently depending on the call.  Some have the player ID as just `id`, others have it as `playerId`, etc.  If I had more time, I would probably try to find a way to make this nicer, or work with the API maintainer (on a client for example) to make a more easily consumable API.
2. For sake of time, I did not include string translations - of course if this were a real app everything would be in the `strings.xml` file and there would be language translations.

### Error States
The app should gracefully handle API errors and network errors - to see the error screen and refresh logic, simply turn off your phone's network connection so that the API calls will fail, and the error screen will be presented.  Then you can turn your connection back on, click refresh, and the screen should load.

### Accessibility
There's nothing in this app that doesn't already have default accessibility tags from the Android system.  There are some icons and images that Jetpack Compose forces you to put a `contentDescription` on, but I intentionally left them null, as I've heard feedback from vision-impaired users that having everything on screen be tagged is distracting and makes the app harder to use.  So in this case, things like text and buttons are tagged, and if there were clickable images or things like that, those would be tagged as well, but this app just happens not to have any of those.

### Testing
The app has basic unit tests for two of its ViewModels.  The `PlayerDetailsViewModel` is essentially just a wrapper around the repository function, and has no state mapper, so I didn't write tests for it because they would either be trivial or testing something that is already covered by the other ViewModels' tests.

### External tools
`sad_hockey_player.png` was generated using ChatGPT.

`nyr_loader.xml` was not created using external tools - it is a modification of a loading indicator I made for the latest version of Luna (in the shape of a crescent moon).  It's just an animated vector drawable where the path stroke is trimmed at certain keyframes to create the loading effect.
