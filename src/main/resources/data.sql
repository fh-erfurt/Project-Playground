
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
(3, 'Erfurt', 'Brühler Garten', '8', '99084', 'Holzheienstraße'),
(4, 'Erfurt', 'Hirschgarten', '47', '99084', 'Neuwerkstraße'),
(5, 'Erfurt', 'Bella', '4', '99094', 'Tettaustraße'),
(6, 'Erfurt', 'Espach', '36', '99094', 'Alfred-Hess-Straße');

insert into PLAYGROUND (ID, CAPACITY_PLAYGROUND, CLEANLINESS, COUNTER_CHILDREN, INFORMATION, STATUS, TITLE, LOCATION_ID) values

(1, 20, 1, 0,   'Gelegen inmitten der Altstadt, hinter der Krämerbrücke und unweit des "Klein-Venedig" von Erfurt, ist der Spielplatz mit seinem Maskottchen, dem Kikaninchen. ' ||
                'Er wurde erst Anfang 2021 komplett neu aufgebaut und die alten Holzspielzeuge wurden durch eine moderne und langlebige Metallkonstruktion ersetzt. '
                'Neben der beliebten Doppelschaukel und dem Ausguck, inklusive Fernrohr, ist besonders der Wasserspielberg im Sommer beliebt und hoch frequentiert. '
                'Für die Eltern werden viele Sitzplätze geboten und unweit des Spielplatzes kann man sich mit Eis und Bratwurst den Aufenthalt so angenehm wie möglich gestalten.'
                , 1, 'Spielplatz Krämerbrücke', 1),
(2, 20, 1, 0,   'Versteckt und nicht jedem bekannt liegt der Spielplatz zwischen den historischen Gassen der Altstadt. Der Neuaufbau des Spielplatzes erfolgte 2018. '
                'Besonders schön ist der große Spielturm mit Hängebrücke und breiter Rutsche. Der große Sandkasten lädt zum Spielen ein und kann mit bereits dort vorhandenem Spielzeug genutzt werden. '
                'Dieser liebevoll gestaltete Spielplatz ist übersichtlich und besonders für kleinere KInder geeignet, da die Eltern immer den Überblick behalten können.'
                , 1, 'Spielplatz Glockengasse', 2),
(3, 20, 1, 0,   'Der Brühler Garten Spielplatz ist einer von wenigen schattigen Spielplätzen in Erfurt. Er bietet auch im Hochsommer durch seine großen Bäume immer Schutz vor der Sonne. '
                'Der nahe gelegene Brühler Garten ist manchmal Schauplatz für kleinere Konzerte und Familienfeste im Sommer. Hier ist der Spielplatz als Auszeit für die Kinder sehr beliebt. '
                'Kinder jeden Alters finden hier immer eine altersgerechte Beschäftigung. Rutsche und Schaukel sind für alle nutzbar und die gut gebauten Wege im Brühler Garten begeistern kleine Rennfahrer mit ihren Rollern und Rädern. '
                , 1, 'Spielplatz Brühler Garten', 3),
(4, 20, 1, 0,   'Im Zuge der Buga wurde dieser Spielplatz 2018 komplett neu gebaut. Er ist inmitten der Innenstadt und unweit des berühtem Angerbrunnens. '
                'Die Spielgeräte sind modern und eher für ältere Kinder geeignet. Besonders die drei Trampoline finden großen Anklang bei den Kindern. '
                'Für die Kleineren gibt es einen großen Sandkasten und eine Babyschaukel. Im Sommer sollte man jedoch auf einen Sonnenschutz achten, da hier keine Bäume sind. '
                'Ausreichend Sitzplätze für die Eltern sind ebenso wie eine nahegelegene Eisdiele vorhanden.'
                , 1, 'Spielplatz Hirschgarten', 4),
(5, 20, 1, 0,   'Als einziger barrierefreier Spielplatz wurde er 2018 fertiggestellt und ist seither sehr beliebt bei den Kindern aller Altersklassen. '
                'Bei diesem tollen Spielplatz treffen Inklusion auf Tolleranz und Spaß auf Abwechslung. Für die Kinder sind besonders die Königinnenschaukel und der riesige Spielturm interessant. '
                'Jugendliche spielen hingegen oft im angrenzenden Ballsportbereich, welcher durch einen Käfig räumlich abgetrennt ist. '
                'Das Rollstuhlkarussell ist für Kinder mit und ohne Beeinträchtung nutzbar. Ein Sinnes-Lernspiel zeit den Kindern die Natur mit all ihren Facetten und gibt einen kurzen Einblick in die Blindenschrift.'
                , 1, 'Spielplatz Bella', 5),
(6, 20, 1, 0,   'Im bekannten Espach-Park ist dieser kleine aber feine Spielplatz gelegen und wird vor allem durch Kinder genutzt, die im Espachcafe mit ihren Eltern einen ruhigen Nachmittag verbringen. '
                'Hier gibt es neben den typischen Gerichten auch wechselnde saisonale Angebote. ' ||
                'Für die Kinder ist das große Piratenschiff eine spannende Alternative zu den anderen Spielplätzen und der große Drehturm erfreut die Kinder und fordert die Fitness der Väter und Mütter.'
                , 1, 'Spielplatz Espach', 6);


insert into PICTURE (ID, NAME, PATH, PLAYGROUND_ID) values
(1,     'Krämerbrücke Ausguck',                 '/images/kraemerbruecke_Ausguck.jpg', 1),
(2,     'Krämerbrücke Dopplschaukel',           '/images/kraemerbruecke_Doppelschaukel.jpg', 1),
(3,     'Krämerbrücke Federwippe',              '/images/kraemerbruecke_Federwippe.jpg', 1),
(4,     'Krämerbrücke Hangelstange',            '/images/kraemerbruecke_Hangelstange.jpg', 1),
(5,     'Krämerbrücke Hochbeet Klassenzimmer',  '/images/kraemerbruecke_Hochbeet_Klassenzimmer.jpg', 1),
(6,     'Krämerbrücke Karussell',               '/images/kraemerbruecke_Karussell.jpg', 1),
(7,     'Krämerbrücke Kikanichen',              '/images/kraemerbruecke_Kikaninchen.jpg', 1),
(8,     'Krämerbrücke Rutsche groß',            '/images/kraemerbruecke_Rutsche_groß.jpg', 1),
(9,     'Krämerbrücke Rutsche klein',           '/images/kraemerbruecke_Rutsche_klein.jpg', 1),
(10,    'Krämerbrücke Sandkasten',              '/images/kraemerbruecke_Sandkasten.jpg', 1),
(11,    'Krämerbrücke Sandkasten 2',            '/images/kraemerbruecke_Sandkasten2.jpg', 1),
(12,    'Krämerbrücke Spieltuerme',             '/images/kraemerbruecke_Spieltuerme.jpg', 1),
(13,    'Krämerbrücke Wasserspielberg',         '/images/kraemerbruecke_Wasserspielberg.jpg', 1),

(14,    'Glockengasse Balancierschlange',        '/images/Glockengasse_Balancierschlange.jpg',2),
(15,    'Glockengasse Spielturm hinten',        '/images/Glockengasse_Bruecke_und_Spielturm_hinten.jpg', 2),
(16,    'Glockengasse Spielturm vorn',          '/images/Glockengasse_Bruecke_und_Spielturm_vorn.jpg', 2),
(17,    'Glockengasse Hangelspiel',             '/images/Glockengasse_Hangelspiel.jpg', 2),
(18,    'Glockengasse Komplettansicht',         '/images/Glockengasse_Komplettansicht.jpg', 2),
(19,    'Glockengasse Rutsche und Kletterwall', '/images/Glockengasse_Rutsche_und_Kletterwall.jpg', 2),
(20,    'Glockengasse Sandkasten',              '/images/Glockengasse_Sandkasten.jpg', 2),
(21,    'Glockengasse Spielhaeuser',            '/images/Glockengasse_Spielhaeuser_und_Spielkiste.jpg', 2),

(22,    'BruehlerGarten Balancierbruecke',      '/images/BruehlerGarten_Balancierbruecke.jpg',3),
(23,    'BruehlerGarten Federwippen',           '/images/BruehlerGarten_Federwippen.jpg',3),
(24,    'BruehlerGarten Kletterturm',           '/images/BruehlerGarten_Kletterturm.jpg',3),
(25,    'BruehlerGarten Komplettansicht',       '/images/BruehlerGarten_Komplettansicht.jpg',3),
(26,    'BruehlerGarten Rutsche',               '/images/BruehlerGarten_Rutsche_und_Spielhaus.jpg',3),
(27,    'BruehlerGarten Schaukel',              '/images/BruehlerGarten_Schaukel.jpg',3),

(28,    'Hirschgarten Drehteller',              '/images/Hirschgarten_Drehteller.jpg',4),
(29,    'Hirschgarten Holztiere',               '/images/Hirschgarten_Holztiere.jpg',4),
(30,    'Hirschgarten Komplettansicht',         '/images/Hirschgarten_Komplettansicht.jpg',4),
(31,    'Hirschgarten Sandkasten',              '/images/Hirschgarten_Sandkasten.jpg',4),
(32,    'Hirschgarten Schaukeln',               '/images/Hirschgarten_Schaukeln.jpg',4),
(33,    'Hirschgarten Sprachrohre',             '/images/Hirschgarten_Sprachrohre.jpg',4),
(34,    'Hirschgarten Sprungkaesten',           '/images/Hirschgarten_Sprungkaesten.jpg',4),

(35,    'Bella Koeniginnenschaukel',            '/images/Bella_Koeniginnenschaukel.jpg',5),
(36,    'Bella Rollstuhl Karussell',            '/images/Bella_Rollstuhl_Karussell.jpg',5),
(37,    'Bella Rutsche',                        '/images/Bella_Rutsche.jpg',5),
(38,    'Bella Sandkasten und Turm',            '/images/Bella_Sandkasten_und_Spielturm.jpg',5),
(39,    'Bella Schiffschaukel',                 '/images/Bella_Schiffschaukel.jpg',5),
(40,    'Bella Sinneslernspiel',                '/images/Bella_SinnesLernspiel.jpg',5),
(41,    'Bella Spielturm barrierefrei',         '/images/Bella_Spielturm_barrierefrei.jpg',5),
(42,    'Bella Trampolin',                      '/images/Bella_Trampolin.jpg',5),
(43,    'Bella Wegweiser1',                     '/images/Bella_Wegweiser1.jpg',5),
(44,    'Bella Wegweiser2',                     '/images/Bella_Wegweiser2.jpg',5),

(45,    'Espach Drehturm',                      '/images/Espach_Drehturm.jpg',6),
(46,    'Espach Holzschiff und Federwippen',    '/images/Espach_Holzschiff_und_Federwippen.jpg',6),
(47,    'Espach Spielhaus',                     '/images/Espach_Spielhaus.jpg',6),
(48,    'Espachcafe',                           '/images/Espach_Espachcafe.jpg',6)
;