



insert into LOCATION (ID, CITYNAME, DISTRICT, HOUSE_NUMBER, POST_CODE, STREETNAME) values
(1, 'Erfurt', 'Krämerbrücke',   '5',    '99084', 'Krämerbrücke'),
(2, 'Erfurt', 'Glockengasse',   '17',   '99084', 'Glockengasse'),
(3, 'Erfurt', 'Brühler Garten', '8',    '99084', 'Holzheienstraße'),
(4, 'Erfurt', 'Hirschgarten',   '47',   '99084', 'Neuwerkstraße'),
(5, 'Erfurt', 'Bella',          '4',    '99094', 'Tettaustraße'),
(6, 'Erfurt', 'Espach',         '36',   '99094', 'Alfred-Hess-Straße');

insert into PLAYGROUND (ID, CAPACITY_PLAYGROUND, CLEANLINESS, COUNTER_CHILDREN, INFORMATION, STATUS, TITLE, LOCATION_ID) values

(1, 20, 0, 0,   'Gelegen inmitten der Altstadt, hinter der Krämerbrücke und unweit des "Klein-Venedig" von Erfurt, ist der Spielplatz mit seinem Maskottchen, dem Kikaninchen. ' ||
                'Er wurde erst Anfang 2021 komplett neu aufgebaut und die alten Holzspielzeuge wurden durch eine moderne und langlebige Metallkonstruktion ersetzt. '
                'Neben der beliebten Doppelschaukel und dem Ausguck, inklusive Fernrohr, ist besonders der Wasserspielberg im Sommer beliebt und hoch frequentiert. '
                'Für die Eltern werden viele Sitzplätze geboten und unweit des Spielplatzes kann man sich mit Eis und Bratwurst den Aufenthalt so angenehm wie möglich gestalten.'
                , 1, 'Spielplatz Krämerbrücke', 1),
(2, 20, 0, 0,   'Versteckt und nicht jedem bekannt liegt der Spielplatz zwischen den historischen Gassen der Altstadt. Der Neuaufbau des Spielplatzes erfolgte 2018. '
                'Besonders schön ist der große Spielturm mit Hängebrücke und breiter Rutsche. Der große Sandkasten lädt zum Spielen ein und kann mit bereits dort vorhandenem Spielzeug genutzt werden. '
                'Dieser liebevoll gestaltete Spielplatz ist übersichtlich und besonders für kleinere KInder geeignet, da die Eltern immer den Überblick behalten können.'
                , 1, 'Spielplatz Glockengasse', 2),
(3, 20, 2, 0,   'Der Brühler Garten Spielplatz ist einer von wenigen schattigen Spielplätzen in Erfurt. Er bietet auch im Hochsommer durch seine großen Bäume immer Schutz vor der Sonne. '
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
(1,     'Krämerbrücke Ausguck',                 '/images/kraemerbruecke_Ausguck.jpg',                       1),
(2,     'Krämerbrücke Dopplschaukel',           '/images/kraemerbruecke_Doppelschaukel.jpg',                1),
(3,     'Krämerbrücke Federwippe',              '/images/kraemerbruecke_Federwippe.jpg',                    1),
(4,     'Krämerbrücke Hangelstange',            '/images/kraemerbruecke_Hangelstange.jpg',                  1),
(5,     'Krämerbrücke Hochbeet Klassenzimmer',  '/images/kraemerbruecke_Hochbeet_Klassenzimmer.jpg',        1),
(6,     'Krämerbrücke Karussell',               '/images/kraemerbruecke_Karussell.jpg',                     1),
(7,     'Krämerbrücke Kikanichen',              '/images/kraemerbruecke_Kikaninchen.jpg',                   1),
(8,     'Krämerbrücke Rutsche groß',            '/images/kraemerbruecke_Rutsche_groß.jpg',                  1),
(9,     'Krämerbrücke Rutsche klein',           '/images/kraemerbruecke_Rutsche_klein.jpg',                 1),
(10,    'Krämerbrücke Sandkasten',              '/images/kraemerbruecke_Sandkasten.jpg',                    1),
(11,    'Krämerbrücke Sandkasten 2',            '/images/kraemerbruecke_Sandkasten2.jpg',                   1),
(12,    'Krämerbrücke Spieltuerme',             '/images/kraemerbruecke_Spieltuerme.jpg',                   1),
(13,    'Krämerbrücke Wasserspielberg',         '/images/kraemerbruecke_Wasserspielberg.jpg',               1),

(14,    'Glockengasse Balancierschlange',        '/images/Glockengasse_Balancierschlange.jpg',              2),
(15,    'Glockengasse Spielturm hinten',        '/images/Glockengasse_Bruecke_und_Spielturm_hinten.jpg',    2),
(16,    'Glockengasse Spielturm vorn',          '/images/Glockengasse_Bruecke_und_Spielturm_vorn.jpg',      2),
(17,    'Glockengasse Hangelspiel',             '/images/Glockengasse_Hangelspiel.jpg',                     2),
(18,    'Glockengasse Komplettansicht',         '/images/Glockengasse_Komplettansicht.jpg',                 2),
(19,    'Glockengasse Rutsche und Kletterwall', '/images/Glockengasse_Rutsche_und_Kletterwall.jpg',         2),
(20,    'Glockengasse Sandkasten',              '/images/Glockengasse_Sandkasten.jpg',                      2),
(21,    'Glockengasse Spielhaeuser',            '/images/Glockengasse_Spielhaeuser_und_Spielkiste.jpg',     2),

(22,    'BruehlerGarten Balancierbruecke',      '/images/BruehlerGarten_Balancierbruecke.jpg',              3),
(23,    'BruehlerGarten Federwippen',           '/images/BruehlerGarten_Federwippen.jpg',                   3),
(24,    'BruehlerGarten Kletterturm',           '/images/BruehlerGarten_Kletterturm.jpg',                   3),
(25,    'BruehlerGarten Komplettansicht',       '/images/BruehlerGarten_Komplettansicht.jpg',               3),
(26,    'BruehlerGarten Rutsche',               '/images/BruehlerGarten_Rutsche_und_Spielhaus.jpg',         3),
(27,    'BruehlerGarten Schaukel',              '/images/BruehlerGarten_Schaukel.jpg',                      3),

(28,    'Hirschgarten Drehteller',              '/images/Hirschgarten_Drehteller.jpg',                      4),
(29,    'Hirschgarten Holztiere',               '/images/Hirschgarten_Holztiere.jpg',                       4),
(30,    'Hirschgarten Komplettansicht',         '/images/Hirschgarten_Komplettansicht.jpg',                 4),
(31,    'Hirschgarten Sandkasten',              '/images/Hirschgarten_Sandkasten.jpg',                      4),
(32,    'Hirschgarten Schaukeln',               '/images/Hirschgarten_Schaukeln.jpg',                       4),
(33,    'Hirschgarten Sprachrohre',             '/images/Hirschgarten_Sprachrohre.jpg',                     4),
(34,    'Hirschgarten Sprungkaesten',           '/images/Hirschgarten_Sprungkaesten.jpg',                   4),

(35,    'Bella Koeniginnenschaukel',            '/images/Bella_Koeniginnenschaukel.jpg',                    5),
(36,    'Bella Rollstuhl Karussell',            '/images/Bella_Rollstuhl_Karussell.jpg',                    5),
(37,    'Bella Rutsche',                        '/images/Bella_Rutsche.jpg',                                5),
(38,    'Bella Sandkasten und Turm',            '/images/Bella_Sandkasten_und_Spielturm.jpg',               5),
(39,    'Bella Schiffschaukel',                 '/images/Bella_Schiffschaukel.jpg',                         5),
(40,    'Bella Sinneslernspiel',                '/images/Bella_SinnesLernspiel.jpg',                        5),
(41,    'Bella Spielturm barrierefrei',         '/images/Bella_Spielturm_barrierefrei.jpg',                 5),
(42,    'Bella Trampolin',                      '/images/Bella_Trampolin.jpg',                              5),
(43,    'Bella Wegweiser1',                     '/images/Bella_Wegweiser1.jpg',                             5),
(44,    'Bella Wegweiser2',                     '/images/Bella_Wegweiser2.jpg',                             5),

(45,    'Espach Drehturm',                      '/images/Espach_Drehturm.jpg',                              6),
(46,    'Espach Holzschiff und Federwippen',    '/images/Espach_Holzschiff_und_Federwippen.jpg',            6),
(47,    'Espach Spielhaus',                     '/images/Espach_Spielhaus.jpg',                             6),
(48,    'Espachcafe',                           '/images/Espach_Espachcafe.jpg',                            6);




insert into USER (ID, ACCESS_LEVEL, CHILDREN, EMAIL, FIRST_NAME, LAST_NAME, PASSWORD, USERNAME, CURRENT_PLAYGROUND_ID)
values
(1,     1,  3, 'marvin.ruppert@fh-erfurt.de',   'Marvin',   'Ruppert',  '12345', 'marvin',  1),
(2,     1,  2, 'mark.nottrott@fh-erfurt.de',    'Mark',     'Nottrott', '12345', 'mark',    2),
(3,     1,  3, 'fabian.seeber@fh-erfurt.de',    'Fabian',   'Seeber',   '12345', 'fabian',  3),
(4,     1,  3, 'katja.fischer@fh-erfurt.de',    'Katja',    'Fischer',  '12345', 'katja',   4);


insert into DEVICE (ID, DESCRIPTION, DEVICE_CAPACITY, DEVICE_STATUS, TITLE, PLAYGROUND_ID) values

(1,     'Schiffschaukel und Kleinkinderschaukel',       3, 0, 'Doppelschaukel',     1 ),
(2,     'Federwippe aus Metall',                        4, 0, 'Federwippe',         1 ),
(3,     'Ausguck mit Fernrohr',                         2, 0, 'Ausguck',            1 ),
(4,     'Hangelstange aus  Metall',                     2, 0, 'Hangelstange',       1 ),
(6,     'Karussell mit Drehteller',                     6, 1, 'Karussell',          1 ),
(7,     'Rutsche groß',                                 1, 0, 'Rutsche',            1 ),
(8,     'Rutsche klein',                                1, 0, 'Rutsche',            1 ),
(9,     'Wasserspielberg mit Pumpe und Wasserspiel',    8, 1, 'Wasserspielberg',    1 ),
(10,    'Sandkasten mit Sitzgelegenheiten',             6, 1, 'Sandkasten',         1 ),

(11,    'große Holzschlange zum Balancieren',           2, 1, 'Balancierschlange',  2 ),
(12,    'Hängebrücke und Spieltürme',                   4, 0, 'Hängebrücke',        2 ),
(13,    'Hangelspiel mit div. Stationen',               2, 1, 'Hangelspiel',        2 ),
(14,    'Schaukel und Kleinkinderschaukel',             2, 0, 'Schaukel',           2 ),
(15,    'Rutsche aus Metall mit Spielhaus',             2, 0, 'Rutsche',            2 ),
(16,    'Sandkasten mit Sitzgelegenheiten',             8, 1, 'Sandkasten',         2 ),
(17,    'Spielhäuser mit Matschküche',                  4, 0, 'Spielhaus',          2 ),
(18,    'Spielkiste mit Sandspielzeug',                 6, 2, 'Spielkiste',         2 ),

(19,    'Balancierbrücke aus Holz und Kettenelementen', 1, 0, 'Balancierbrücke',    3 ),
(20,    'Federwippen rot und gelb',                     2, 1, 'Federwippen',        3 ),
(21,    'Kletterturm mit versch. Elementen',            2, 1, 'Kletterturm',        3 ),
(22,    'Rutsche mit Spielturm',                        3, 1, 'Rutsche',            3 ),
(23,    'Schaukel und Kleinkinderschaukel',             2, 1, 'Schaukel',           3 ),

(24,    'großer Drehteller',                            6, 1, 'Drehteller',         4 ),
(25,    'Holztiere zum Reiten',                         2, 0, 'Holztiere',          4 ),
(26,    'großer Sandkasten mit Holztier',               9, 1, 'Sandkasten',         4 ),
(27,    'Schaukel und Kleinkinderschaukel',             2, 0, 'Schaukel',           4 ),
(28,    'Sprachrohre über weite Entfernung',            6, 1, 'Sprachrohre',        4 ),
(29,    'Trampoline aus Gummi',                         3, 0, 'Trampoline',         4 ),

(30,    'Königinnenschaukel mit 3 einzelnen Tellern',   3, 0, 'Königinnenschaukel', 5 ),
(31,    'Karussell barrierefrei',                       6, 1, 'Karussell',          5 ),
(32,    'Sandkasten mit Matschküche',                   9, 1, 'Sandkasten',         5 ),
(33,    'Schiffschaukel mit Netz und Halteseil',        4, 0, 'Schiffschaukel',     5 ),
(34,    'Sinneslernspiel - Tast- und Wissensspiel',     5, 1, 'Sinneslernspiel',    5 ),
(35,    'Trampolin klein aus Gummi',                    1, 1, 'Trampolin',          5 ),

(36,    'großer Drehturm mit Netz und Gummiboden',      6, 1, 'Drehturm',           6 ),
(37,    'Spielturm mit Rutsche',                        4, 1, 'Spielturm',          6 ),
(38,    'Federwippen - Fische',                         2, 0, 'Federwippen',        6 ),
(39,    'Boot aus Holz für echte Kapitäne',             6, 1, 'Spielboot',          6 );


insert into EXPANSION (ID, DESCRIPTION, NUMBER_OF_PERSONS, TITLE, PLAYGROUND_ID) values
( 1, 'Toilette im Wirtshaus (Nutzungsgebühr)',          6,  'Toilette',              1),
( 2, 'Wirtshaus zur Versorgung mit Essen & Trinken',    5,  'Wirtshaus',             1),
( 3, 'Café für Kaffee und Kuchen',                      5,  'Café',                  1),

( 4, 'Imbiss',                                          5,  'Imbiss',                2),

( 5, 'Parkanlage mit gelegentlicher Live-Musik',        200,'Park',                  3),
( 6, 'öffentliche Toilette (Nutzungsgebühr)',           5,  'Toilette',              3),

( 7, 'Comicbuchladen mit Café',                         10, 'Comicbuchladen',        4),
( 8, 'Bäckerei mit Café',                               5,  'Bäckerei',              4),
( 9, 'Irish-Pub für die Papas',                         15, 'Pub',                   4),

( 10, 'Käfig für Fußball und Basketball',               15, 'Käfig',                 5),

( 11, 'Neu saniertes Café mit extra Eis-Verkauf',       40, 'Espach-Café',           6);