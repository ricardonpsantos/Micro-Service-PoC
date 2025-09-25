CREATE TABLE notification (
    notification_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    notification_type VARCHAR(20) NOT NULL,
    title VARCHAR(255),
    message TEXT,
    notification_status VARCHAR(20) NOT NULL,
    notification_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    notification_sent TIMESTAMP NULL
);


CREATE TABLE event_log (
    event_log_id SERIAL PRIMARY KEY,
    event_method VARCHAR(50) NOT NULL,
    payload TEXT,
    process_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    notifications_id INT UNIQUE,
    CONSTRAINT fk_eventlog_notification FOREIGN KEY (notifications_id)
        REFERENCES notification (notification_id)
        ON DELETE CASCADE
);