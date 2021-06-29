
insert into USER (ID, ACCESS_LEVEL, CHILDREN) values
(1, 1, 3 ),
(2,0,3),
(3,2,3);

INSERT INTO ACCOUNT VALUES
(1, 'marvin', '12345', 'marvin.ruppert@fh-erfurt.de',1),
(2, 'katja', '12345', 'katja.fischer@fh-erfurt.de',2),
(3, 'mark', '12345', 'mark.nottrott@fh-erfurt.de',3);


insert into LOCATION (ID, CITYNAME, DISTRICT, HOUSE_NUMBER, POST_CODE, STREETNAME) values
(1, 'Erfurt', 'Krämerbrücke', '5', '99084', 'Krämerbrücke');

insert into PLAYGROUND (ID, CAPACITY_PLAYGROUND, CLEANLINESS, COUNTER_CHILDREN, INFORMATION, STATUS, TITLE, LOCATION_ID) values
(1, 20, 1, 0, '', 1, 'Spielplatz Krämerbrücke', 1);


insert into PICTURE (ID, NAME, PATH, PLAYGROUND_ID) values
(1, 'Bild Krämerbrücke 01', '/Spielplaetze/Kikaninchen/Kikaninchen.jpg', 1);