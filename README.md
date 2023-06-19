# eu4-x10-ideas
Script for taking the various Ideas in EU4 and multiplying their values by 10.


ex,  France Idea "Elan" goes from the original +15% Morale to +150% Morale.
But for ALL National Ideas (incl. Ambition and Tradition) and Idea Groups.


Why? It's funny, and makes for a few absolutely chaotic - if not very entertaining - games. 
Prussian Space Marines are even more terrifying, 
Spain and Portugal colonize the Americas in 1/20th of the usual time, 
Great Britain will never lose a naval engagement,
just your usual EU4 OPness, except even more so.


How to use?
Option 1: just use my two existing mods up on Steam Workshop.
For vanilla Eu4: https://steamcommunity.com/sharedfiles/filedetails/?id=2989025425
For Extended Timeline: https://steamcommunity.com/sharedfiles/filedetails/?id=2989053021

Option 2: do it yourself
1. Clone repository.
2. Run maven commands to resolve dependencies. Idk what they are, I just let VSCode's Maven integration auto-detect dependencies for me.
3. In project, navigate to "demo/src"
4. Create two folders: "input" and "output", so it looks like:
  - demo/src/input/
  - demo/src/output/
5. Place any Ideas files into the /input/ folder. For Vanilla, this can include the files "00_basic_ideas.txt", "00_country_ideas.txt", "zz_group_ideas.txt", and "zzz_default_idea.txt". 


Also works for modded/new nations, such as Extended Timeline and Voltaire's Nightmare (and should work for any other mod too). Just find their unique Ideas files and slap 'em in the /input/ folder.


Script should never need updating, unless Paradox decides to completely restructure their Ideas file formatting or structure, or maybe uses some sort of new annotation. Which I doubt they'll do, their code is reportedly spaghetti enough as is. Can't be worse than mine, though. I didn't even bother with proper TDD for this one.


If this ever breaks, or you find a missing un-changed idea, feel free to email or otherwise message me.
