create table users(
    user_id uuid  default gen_random_uuid()  primary key,
    email varchar(200) not null UNIQUE,
    password varchar(200) not null,
    profile_image varchar(200)
);

create table otps(
    otp_id uuid  default gen_random_uuid()  primary key,
    otp_code varchar(255) not null ,
    issued_at timestamp not null,
    expiration timestamp not null ,
    verify boolean not null ,
    user_id uuid not null ,
    FOREIGN KEY (user_id) REFERENCES users (user_id) ON UPDATE CASCADE ON DELETE CASCADE
);

create table categories(
    category_id uuid  default gen_random_uuid() primary key,
    name varchar(200) not null,
    description text ,
    user_id uuid not null ,
    FOREIGN KEY (user_id) REFERENCES users (user_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE expenses(
    expense_id  uuid  default gen_random_uuid()  PRIMARY KEY,
    amount decimal not null ,
    description text ,
    date date not null ,
    user_id uuid not null,
    category_id uuid not null,
    FOREIGN KEY (user_id) REFERENCES users (user_id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (category_id) REFERENCES categories (category_id) ON UPDATE CASCADE ON DELETE CASCADE
);