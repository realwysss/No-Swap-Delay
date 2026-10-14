<p align="center"><img src="src/main/resources/assets/modid/icon.png" width="128"></p>

# no swap delay

client side fabric mod for minecraft 1.21.11. when you switch hotbar slots, the item use cooldown gets cut down so you can place or use the new item right away.

it checks your selected slot every tick, and when it changed it lowers the cooldown to a random number between your min and max (1 and 2 by default).

## settings

open mod menu, find no swap delay and click config. there is an on switch and min and max ticks sliders from 0 to 4. careful, putting both at 0 can get you flagged by anticheats.

## install

you need fabric loader, and mod menu with cloth config for the settings screen. put the jar from the releases page in your mods folder.

## build

`./gradlew build`, the jar ends up in build/libs.

cc0, do what you want with it.
