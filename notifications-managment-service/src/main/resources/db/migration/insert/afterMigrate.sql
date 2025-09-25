INSERT INTO notification (user_id, notification_type, title, message, notification_status, notification_date, notification_sent)
VALUES
(1, 'EMAIL', 'Bem-vindo!', 'Obrigado por se registar no sistema.', 'PENDING', DATEADD('DAY', -20, CURRENT_TIMESTAMP), NULL),
(2, 'PUSH', 'Novo Evento', 'Um novo evento de escalada foi criado.', 'PENDING', DATEADD('DAY', -19, CURRENT_TIMESTAMP), NULL),
(3, 'SMS', 'Lembrete', 'Não se esqueça do evento amanhã.', 'PENDING', DATEADD('DAY', -18, CURRENT_TIMESTAMP), NULL),
(4, 'EMAIL', 'Promoção', 'Ganhe desconto no próximo evento.', 'PENDING', DATEADD('DAY', -17, CURRENT_TIMESTAMP), NULL),
(5, 'PUSH', 'Atualização de rota', 'Nova rota adicionada no ginásio.', 'PENDING', DATEADD('DAY', -16, CURRENT_TIMESTAMP), NULL),
(6, 'EMAIL', 'Notificação geral', 'Este é um aviso importante.', 'PENDING', DATEADD('DAY', -15, CURRENT_TIMESTAMP), NULL),
(7, 'SMS', 'Confirmação', 'Sua inscrição foi recebida.', 'PENDING', DATEADD('DAY', -14, CURRENT_TIMESTAMP), NULL),
(8, 'PUSH', 'Aviso', 'O evento foi alterado de data.', 'PENDING', DATEADD('DAY', -13, CURRENT_TIMESTAMP), NULL),
(9, 'EMAIL', 'Lembrete de senha', 'Clique aqui para redefinir sua senha.', 'PENDING', DATEADD('DAY', -12, CURRENT_TIMESTAMP), NULL),
(10, 'SMS', 'Aviso de falha', 'Tentativa de login suspeita.', 'PENDING', DATEADD('DAY', -11, CURRENT_TIMESTAMP), NULL),
(11, 'EMAIL', 'Boas-vindas!', 'Bem-vindo à comunidade de escalada!', 'PENDING', DATEADD('DAY', -10, CURRENT_TIMESTAMP), NULL),
(12, 'PUSH', 'Evento Chegando', 'O evento começa em 2 dias.', 'PENDING', DATEADD('DAY', -9, CURRENT_TIMESTAMP), NULL),
(13, 'EMAIL', 'Newsletter', 'Confira as novidades desta semana.', 'PENDING', DATEADD('DAY', -8, CURRENT_TIMESTAMP), NULL),
(14, 'SMS', 'Código de verificação', 'Seu código é 123456.', 'PENDING', DATEADD('DAY', -7, CURRENT_TIMESTAMP), NULL),
(15, 'PUSH', 'Atualização', 'O sistema passará por manutenção.', 'PENDING', DATEADD('DAY', -6, CURRENT_TIMESTAMP), NULL),
(16, 'EMAIL', 'Informativo', 'Alterações nos termos de uso.', 'PENDING', DATEADD('DAY', -5, CURRENT_TIMESTAMP), NULL),
(17, 'SMS', 'Cancelamento', 'O evento foi cancelado.', 'PENDING', DATEADD('DAY', -4, CURRENT_TIMESTAMP), NULL),
(18, 'PUSH', 'Convite', 'Você foi convidado para um grupo.', 'PENDING', DATEADD('DAY', -3, CURRENT_TIMESTAMP), NULL),
(19, 'EMAIL', 'Alerta', 'Atividade suspeita detectada.', 'PENDING', DATEADD('DAY', -2, CURRENT_TIMESTAMP), NULL),
(20, 'PUSH', 'Evento Hoje', 'O evento começa hoje às 18h.', 'PENDING', DATEADD('DAY', -1, CURRENT_TIMESTAMP), NULL);

INSERT INTO event_log (event_method, payload, process_date, notifications_id)
VALUES
('POST', '{"info":"criação de utilizador"}', CURRENT_TIMESTAMP, 1),
('GET', '{"info":"consulta de eventos"}', CURRENT_TIMESTAMP, 2),
('DELETE', '{"info":"remoção de inscrição"}', CURRENT_TIMESTAMP, 3);