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