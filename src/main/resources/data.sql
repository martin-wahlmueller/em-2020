
INSERT INTO em_group(id, group_name) VALUES
(1, 'A'),
(2, 'B'),
(3, 'C'),
(4, 'D'),
(5, 'E'),
(6, 'F');

INSERT INTO em_team (id, team_name) VALUES
(1, 'Belgien'),
(2, 'Italien'),
(3, 'Russland'),
(4, 'Polen'),
(5, 'Ukraine'),
(6, 'Spanien'),
(7, 'Türkei'),
(8, 'Frankreich'),
(9, 'England'),
(10, 'Tschechien'),
(11, 'Finnland'),
(12, 'Schweden'),
(13, 'Deutschland'),
(14, 'Österreich'),
(15, 'Niederlande'),
(16, 'Kroatien'),
(17, 'Portugal'),
(18, 'Schweiz'),
(19, 'Dänemark'),
(20, 'Wales'),
(21, 'Playoff A'),
(22, 'Playoff B'),
(23, 'Playoff C'),
(24, 'Playoff D');

INSERT INTO em_group_teams (group_id, teams_id) VALUES
(1,7),(1,2),(1,20),(1,18),
(2,19),(2,11),(2,1),(2,3),
(3,15),(3,5),(3,14),(3,24),
(4,9),(4,16),(4,23),(4,10),
(5,6),(5,12),(5,4),(5,22),
(6,21),(6,17),(6,8),(6,13);