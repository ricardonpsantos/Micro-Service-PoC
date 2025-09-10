CREATE TABLE participants (
    participant_id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(50) NOT NULL UNIQUE,
    address VARCHAR(50) NOT NULL UNIQUE,
    phone VARCHAR(50) NOT NULL UNIQUE,
    identification_id VARCHAR(50)
);

CREATE TABLE categories (
    category_id SERIAL PRIMARY KEY,
    category_name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE climbing_routes (
    route_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category_id INT NOT NULL,
    difficulty_level VARCHAR(50) NOT NULL,
    route_height INT NOT NULL,
    CONSTRAINT fk_climbingroute_category FOREIGN KEY (category_id)
        REFERENCES categories(category_id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE events (
    event_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(2000) NOT NULL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    location VARCHAR(255) NOT NULL,
    status VARCHAR(30),
    CONSTRAINT chk_events_dates CHECK (end_date > start_date)
);

CREATE TABLE event_routes (
    event_id INT NOT NULL,
    route_id INT NOT NULL,
    PRIMARY KEY (event_id, route_id),
    CONSTRAINT fk_event_routes_event
        FOREIGN KEY (event_id) REFERENCES events(event_id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_event_routes_route
        FOREIGN KEY (route_id) REFERENCES climbing_routes(route_id)
        ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE scores (
    id SERIAL PRIMARY KEY,
    participant_id INT NOT NULL,
    route_id INT NOT NULL,
    event_id INT NOT NULL,
    points INT NOT NULL,
    CONSTRAINT fk_score_participant
        FOREIGN KEY (participant_id) REFERENCES participants(participant_id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_score_route
        FOREIGN KEY (route_id) REFERENCES climbing_routes(route_id)
        ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT fk_score_event
        FOREIGN KEY (event_id) REFERENCES events(event_id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT uq_score UNIQUE (participant_id, route_id, event_id)
);

CREATE TABLE notifications (
    notification_id SERIAL PRIMARY KEY,
    event_id INT NOT NULL,
    message VARCHAR(1000) NOT NULL,
    date_send TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_notifications_event
        FOREIGN KEY (event_id) REFERENCES events(event_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE event_participants (
    event_id INT NOT NULL,
    participant_id INT NOT NULL,
    date_joined TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, -- opcional

    CONSTRAINT pk_event_participants PRIMARY KEY (event_id, participant_id),

    CONSTRAINT fk_event_participants_event
        FOREIGN KEY (event_id) REFERENCES events(event_id)
        ON DELETE CASCADE ON UPDATE CASCADE,

    CONSTRAINT fk_event_participants_participant
        FOREIGN KEY (participant_id) REFERENCES participants(participant_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE results (
    id_results SERIAL PRIMARY KEY,
    participant_id INT NOT NULL,
    event_id INT NOT NULL,
    result_points INT NOT NULL,
    CONSTRAINT fk_winner_participant
        FOREIGN KEY (participant_id) REFERENCES participants(participant_id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_winner_event
        FOREIGN KEY (event_id) REFERENCES events(event_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);
