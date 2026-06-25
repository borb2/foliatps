## Placeholders
--- ---

#### %foliatps_mspt%
The average milliseconds per tick, rounded to one decimal place. Example: 3.5

#### %foliatps_mspt_colored%
The same value as mspt, but colored. Green under 40ms, yellow from 40 to 47ms, red above 47ms.

#### %foliatps_tps%
Ticks per second, calculated from mspt and capped at 20.0, rounded to one decimal place. Example: 20.0

#### %foliatps_tps_colored%
The same value as tps, but colored. Green above 18, yellow from 15 to 18, red below 15.

#### %foliatps_tick_health%
How much tick budget is left as a percentage, where 0ms is 100 percent and 50ms is 0 percent. Clamped between 0 and 100. Example: 94%

#### %foliatps_tick_health_colored%
The same value as tick_health, but colored. Green above 85, yellow from 70 to 85, red below 70.
