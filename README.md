# igt
igt J2EE test

Using the supplied XML file (igt/src/main/resources/Java_EE_Test.xml), please complete the following tasks:


### 1. A list ordered by cod_programa in descendent order of the events with this format:


sigla_sport, des_manif, des_avvenimento, dateTime


e.g.
CALCIO, Europa League, Villareal - Moncheglad, 27-11-2014 21:05

(note the different format of the date)

### 2. A list ordered by dateTime in descending order of the events with the same format as in 1


### 3. A list of all the different types of des_tipo_sco divided by sigla_sport


e.g. for sigla_sport = TENNIS :


LIVE VINC. PARTITA, LIVE VINC. SET 1, etc


for sigla_sport = CALCOP :


LIVE 1X2, etc.


### 4. Output of the different sigla_sport based on the user input, e.g. 1 for CALCIO, 2 for
TENNIS etc, the list of the events for that sport ordered by dateTime prepended with 1,2,3,4
indicating the order of the list.


e.g. given the output of the first step being:


1. DYNAMO MOSCOW - PANATHINA


2. FC KRASNODAR - OSC LILLE


3. ..


…on user typing 1 the program would display on the screen:


1. LIVE 1X2


2. LIVE SEGNA GOL


3. LIVE U/O 2,5


4. LIVE 1X2 PRIMO TEMPO


Please package send back a zip file with the source code and an executable jar we can run from console



