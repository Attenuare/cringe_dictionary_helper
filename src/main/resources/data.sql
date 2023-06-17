create table words(
    id int primary key auto_increment,
    description varchar(100) not null,
    meaning varchar(500) not null
);

insert into words (description, meaning) values
('de base', 'Morrer...'),
('F','Prestar condolências.'),
('Não Tankou', 'Não aguentou.'),
('Cringe', '25+'),
('chavoso','Estiloso, (Gangsta)');
