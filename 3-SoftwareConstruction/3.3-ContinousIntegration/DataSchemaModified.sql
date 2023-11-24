CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username TEXT NOT NULL CHECK (username ~ '^[A-Za-z0-9_]{1,50}$'),
    user_password TEXT NOT NULL CHECK (password ~ '^.{10,30}$')
);

CREATE TABLE light_parameters (
    param_id SERIAL PRIMARY KEY,
    min_brightness INTEGER NOT NULL CHECK (
        min_brightness >= 25 AND min_brightness <= 100
    ),
    check_time TIME NOT NULL,
    user_id INTEGER NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE regulating_system (
    system_id SERIAL PRIMARY KEY,
    outdoor_factor INTEGER NOT NULL CHECK (outdoor_factor > 50),
    light_lvl INTEGER NOT NULL CHECK (light_lvl > 0),
    input_params_id INTEGER NOT NULL,
    UNIQUE (input_params_id),
    FOREIGN KEY (input_params_id) REFERENCES light_parameters (param_id)
);

CREATE TABLE report_generation (
    gen_id SERIAL PRIMARY KEY,
    status BOOLEAN NOT NULL,
    user_id INTEGER NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE light_report (
    report_id SERIAL PRIMARY KEY,
    time_period TIME NOT NULL,
    light_stats INTEGER NOT NULL CHECK (light_stats > 0),
    regulating_system_id INTEGER NOT NULL,
    FOREIGN KEY (regulating_system_id) REFERENCES regulating_system (system_id),
    report_gen_id INTEGER NOT NULL,
    UNIQUE (report_gen_id),
    FOREIGN KEY (report_gen_id) REFERENCES report_generation (gen_id)
);
