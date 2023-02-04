# RockPaperScissorsWeb
RockPaperScissorsWeb
1) I made controllers because I suppose there will be frontend
2) I made an exception, in case it would be necessary to make a handler for intercepting and redirecting to other pages.
3) I used MapStruct because it's convenience.
4) Such an architecture of models, because it seemed to me that it would be convenient and it could be easily changed
5) Service for the application. I thought it would be nice to create a game with save and load, but then 
I got too lazy to add embedding mongoDB, and part of the functionality was implemented.
6) The simplest tests to check the basic functionality.

The app works like this. First we start the game on /start, then we can either end it with /finish and return the final 
result or continue playing /nextRound?choice=$param. If the number of moves is over, then we return the current state of the game. 
$param - ROCK, PAPER, SCISSORS. If there is another value, then 500.

Cons - no front, no error interceptor. It could be done through moves using stateMachine. There is no saving, 
it was possible to save to a file or to a database, but it was difficult to test by hand and even more tests. 
And it would take me much longer than 3 hours.

You can add a test. You can cut logic and paste it elsewhere.
