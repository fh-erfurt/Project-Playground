
insert into USER (ID, ACCESS_LEVEL, CHILDREN) values
(1,1,3),
(2,0,3),
(3,2,3);

INSERT INTO ACCOUNT VALUES
(1, 'marvin.ruppert@fh-erfurt.de', '12345', 'marvin',1),
(2, 'katja.fischer@fh-erfurt.de','12345', 'katja',2),
(3, 'mark.nottrott@fh-erfurt.de', '12345', 'mark',3),
(4, 'fabian.seeber@fh-erfurt.de','12345', 'fabian',3);


insert into LOCATION (ID, CITYNAME, DISTRICT, HOUSE_NUMBER, POST_CODE, STREETNAME) values
(1, 'Erfurt', 'Krämerbrücke', '5', '99084', 'Krämerbrücke'),
(2, 'Erfurt', 'Glockengasse', '17', '99084', 'Glockengasse'),
(3, 'Erfurt', 'Holzheienstraße', '8', '99084', 'Brühler Garten'),
(4, 'Erfurt', 'Neuwerkstraße', '47', '99084', 'Hirschgarten'),
(5, 'Erfurt', 'Tettaustraße', '4', '99094', 'Bella'),
(6, 'Erfurt', 'Alfred-Hess-Straße', '36', '99094', 'Espach');

insert into PLAYGROUND (ID, CAPACITY_PLAYGROUND, CLEANLINESS, COUNTER_CHILDREN, INFORMATION, STATUS, TITLE, LOCATION_ID) values

(1, 20, 1, 0,   'Gelegen inmitten der Altstadt, hinter der Krämerbrücke und unweit des "Klein-Venedig" von Erfurt, ist der Spielplatz mit seinem Maskottchen, dem Kikaninchen.' ||
                'Er wurde erst Anfang 2021 komplett neu aufgebaut und die alten Holzspielzeuge wurden durch eine moderne und langlebige Metallkonstruktion ersetzt.'
                'Neben der beliebten Doppelschaukel und dem Ausguck, inklusive Fernrohr, ist besonders der Wasserspielberg im Sommer beliebt und hoch frequentiert.'
                'Für die Eltern werden viele Sitzplätze geboten und unweit des Spielplatzes kann man sich mit Eis und Bratwurst den Aufenthalt so angenehm wie möglich gestalten.'
                , 1, 'Spielplatz Krämerbrücke', 1),
(2, 20, 1, 0,   'Versteckt und nicht jedem bekannt liegt der Spielplatz zwischen den historischen Gassen der Altstadt. Der Neuaufbau des Spielplatzes erfolgte 2018.'
                'Besonders schön ist der große Spielturm mit Hängebrücke und breiter Rutsche. Der große Sandkasten lädt zum Spielen ein und kann mit bereits dort vorhandenem Spielzeug genutzt werden'
                'Dieser liebevoll gestaltete Spielplatz ist übersichtlich und besonders für kleinere KInder geeignet, da die Eltern immer den Überblick behalten können.'
                , 1, 'Spielplatz Glockengasse', 2),
(3, 20, 1, 0,   'Der Brühler Garten Spielplatz ist einer von wenigen schattigen Spielplätzen in Erfurt. Er bietet auch im Hochsommer durch seine großen Bäume immer Schutz vor der Sonne.'
                'Der nahe gelegene Brühler Garten ist manchmal Schauplatz für kleinere Konzerte und Familienfeste im Sommer. Hier ist der Spielplatz als Auszeit für die Kinder sehr beliebt.'
                'Kinder jeden Alters finden hier immer eine altersgerechte Beschäftigung. Rutsche und Schaukel sind für alle nutzbar und die gut gebauten Wege im Brühler Garten begeistern kleine Rennfahrer mit ihren Rollern und Rädern.'
                , 1, 'Spielplatz Brühler Garten', 3),
(4, 20, 1, 0,   'Im Zuge der Buga wurde dieser Spielplatz 2018 komplett neu gebaut. Er ist inmitten der Innenstadt und unweit des berühtem Angerbrunnens.'
                'Die Spielgeräte sind modern und eher für ältere Kinder geeignet. Besonder die drei Trampoline finden großen Anklang bei den Kindern.'
                'Für die Kleineren gibt es einen großen Sandkasten und eine Babyschaukel. Im Sommer sollte man jedoch auf einen Sonnenschutz achten, da hier keine Bäume sind.'
                'Ausreichend Sitzplätze für die Eltern sind ebenso wie eine nahegelegene Eisdiele vorhanden.'
                , 1, 'Spielplatz Hirschgarten', 4),
(5, 20, 1, 0,   'Als einziger barrierefreier Spielplatz wurde er 2018 fertiggestellt und ist seither sehr beliebt bei den Kindern aller Altersklassen.'
                'Bei diesem tollen Spielplatz treffen Inklusion auf Tolleranz und Spaß auf Abwechslung. Für die Kinder sind besonders die Königinnenschaukel und der riesige Spielturm interessant.'
                'Jugendliche spielen hingegen oft im angrenzenden Ballsportbereich, welcher durch einen Käfig räumlich abgetrennt ist.'
                'Das Rollstuhlkarussell ist für Kinder mit und ohne Beeinträchtung nutzbar. Ein Sinnes-Lernspiel zeit den Kindern die Natur mit all ihren Facetten und gibt einen kurzen Einblick in die Blindenschrift'
                , 1, 'Spielplatz Bella', 5),
(6, 20, 1, 0,   'Im bekannten Espach-Park ist dieser kleine aber feine Spielplatz gelegen und wird vor allem durch Kinder genutzt, die im Espachcafe mit ihren Eltern einen ruhigen Nachmittag verbringen.'
                'Hier gibt es neben den typischen Gerichten auch wechselnde saisonale Angebote.' ||
                'Für die Kinder ist das große Piratenschiff eine spannende Alternative zu den anderen Spielplätzen und der große Drehturm erfreut die Kinder und fordert die Fitness der Väter und Mütter.'
                , 1, 'Spielplatz Espach', 6);


insert into PICTURE (ID, NAME, PATH, PLAYGROUND_ID) values
(1, 'Bild Krämerbrücke 01', '/images/Kikaninchen_Rutsche groß.jpg', 1),
(2, 'Bild Krämerbrücke 01', '/images/Kikaninchen_Ausguck.jpg', 1),
(3, 'Bild Krämerbrücke 01', '/images/Kikaninchen_Kikaninchen.jpg', 1);