
INSERT INTO participants (name,email,address,phone,identification_id) VALUES ('Ricardo','ricardo@gmail.com','Rua das Flores','924161276','992932923');
INSERT INTO participants (name,email,address,phone,identification_id) VALUES('Pedro','pedro@gmail.com','Lisboa','912482912','99999999');



INSERT INTO categories (category_name) VALUES
  ('Boulder'),
  ('Sport Climbing'),
  ('Trad Climbing'),
  ('Speed Climbing'),
  ('Ice Climbing'),
  ('Mixed Climbing');

  INSERT INTO climbing_routes (name, category_id, difficulty_level, route_height) VALUES
    ('La Rambla', 2, 'HARD', 41),             -- Sport Climbing
    ('Midnight Lightning', 1, 'MODERATE', 5), -- Boulder
    ('The Nose', 3, 'EXTREME', 880),          -- Trad Climbing (El Capitan)
    ('Speed Wall Standard', 4, 'HARD', 15),   -- Speed Climbing
    ('Frozen Tears', 5, 'EXTREME', 120),      -- Ice Climbing
    ('Mixed Madness', 6, 'HARD', 35);


       INSERT INTO events (name, description, start_date, end_date, location, status) VALUES
         ('Open Climbing Day',
          'Evento de iniciação e diversão para todas as idades, com várias vias e monitores.',
          '2025-09-20 10:00:00', '2025-09-20 18:00:00',
          'Parque Municipal de Escalada',
          'PLANNED'),

         ('Fall Boulder Challenge',
          'Competição de boulder com qualificação de manhã e finais ao fim do dia.',
          '2025-10-05 09:00:00', '2025-10-05 19:30:00',
          'Boulder Lab Centro',
          'PLANNED');

       -- 4) Mapear rotas aos eventos (ajusta os IDs conforme o teu seed do V2)
       -- Event 1: usar rotas 1 e 2
       INSERT INTO event_routes (event_id, route_id) VALUES
         (1, 1),
         (1, 2);

       -- Event 2: usar rotas 3 e 4
       INSERT INTO event_routes (event_id, route_id) VALUES
         (2, 3),
         (2, 4);-- Mixed Climbing

         INSERT INTO scores (participant_id, route_id, event_id, points) VALUES
           (1, 1, 1, 95),   -- participante 1 no evento 1, rota 1
           (1, 2, 1, 88),   -- participante 1 no evento 1, rota 2
           (2, 1, 1, 76),   -- participante 2 no evento 1, rota 1
           (2, 3, 2, 92);   -- participante 2 no evento 2, rota 3


           INSERT INTO notifications (event_id, message, date_send) VALUES
             (1, 'Lembramos que o check-in abre 30 minutos antes do início.', '2025-09-19 12:00:00'),
             (1, 'Previsão de calor — tragam água e protetor solar.',          '2025-09-19 18:00:00'),
             (2, 'Qualificação começa às 09:00 — cheguem cedo!',               '2025-10-04 17:00:00');