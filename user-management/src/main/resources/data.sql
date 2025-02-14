DROP TABLE IF EXISTS `users`;  -- Rename to `users` instead of `user`

CREATE TABLE `users` (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    phone VARCHAR(15),
    profile_picture VARCHAR(255),
    role VARCHAR(50) NOT NULL DEFAULT 'USER',
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    is_verified BOOLEAN NOT NULL DEFAULT FALSE,
    verification_code VARCHAR(6),
    last_login TIMESTAMP NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Insert 10 sample users into the users table
INSERT INTO `users` (username, email, password, first_name, last_name, phone, profile_picture, role, is_active, is_verified, verification_code, last_login) 
VALUES 
('john_doe', 'john.doe@example.com', '$2a$10$hashedpassword1', 'John', 'Doe', '1234567890', 'img1.jpg', 'USER', TRUE, FALSE, '123456', NULL),
('jane_smith', 'jane.smith@example.com', '$2a$10$hashedpassword2', 'Jane', 'Smith', '9876543210', 'img2.jpg', 'USER', TRUE, TRUE, NULL, '2025-02-10 14:23:00'),
('admin_user', 'admin@example.com', '$2a$10$hashedpassword3', 'Admin', 'User', '1122334455', 'img3.jpg', 'ADMIN', TRUE, TRUE, NULL, '2025-02-11 09:00:00'),
('alice_wonder', 'alice.wonder@example.com', '$2a$10$hashedpassword4', 'Alice', 'Wonder', '5566778899', 'img4.jpg', 'USER', TRUE, FALSE, '654321', NULL),
('bob_builder', 'bob.builder@example.com', '$2a$10$hashedpassword5', 'Bob', 'Builder', '4433221100', 'img5.jpg', 'MODERATOR', TRUE, TRUE, NULL, '2025-02-12 18:45:00'),
('charlie_brown', 'charlie.brown@example.com', '$2a$10$hashedpassword6', 'Charlie', 'Brown', '7788990011', 'img6.jpg', 'USER', FALSE, FALSE, '111222', NULL),
('daisy_duck', 'daisy.duck@example.com', '$2a$10$hashedpassword7', 'Daisy', 'Duck', '2233445566', 'img7.jpg', 'USER', TRUE, TRUE, NULL, '2025-02-13 08:30:00'),
('elon_musk', 'elon.musk@example.com', '$2a$10$hashedpassword8', 'Elon', 'Musk', '6677889900', 'img8.jpg', 'ADMIN', TRUE, TRUE, NULL, '2025-02-10 21:15:00'),
('frank_castle', 'frank.castle@example.com', '$2a$10$hashedpassword9', 'Frank', 'Castle', '9998887776', 'img9.jpg', 'USER', FALSE, FALSE, '777888', NULL),
('grace_hopper', 'grace.hopper@example.com', '$2a$10$hashedpassword10', 'Grace', 'Hopper', '1112223334', 'img10.jpg', 'USER', TRUE, TRUE, NULL, '2025-02-09 12:00:00');

