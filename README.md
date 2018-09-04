[![Build Status](https://travis-ci.org/perrymant/moneymaker.svg?branch=sprint-2)](https://travis-ci.org/perrymant/moneymaker) 
![GitHub](https://img.shields.io/github/license/mashape/apistatus.svg) 
![GitHub package version](https://img.shields.io/github/package-json/v/badges/shields.svg)


TODO:
1. The original README.md was deleted from this branch. Are there other files missing?
1. FlipTableTest: I want main to be able to use the FlipTable, but I am unsuccessful with using the .fromIterable method, 
so instead I want to use FlipTableConverters.fromObjects. While I have a header, the second argument needs to be of 
String[][] type. This suggests I need to update the Budget.report() method - so that the steam converts this to nested arrays.