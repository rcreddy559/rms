-- Drop table if it exists
DROP TABLE IF EXISTS room_entity;

-- Create the rooms table
CREATE TABLE room_entity (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    room_number VARCHAR(50) NOT NULL,
    price DECIMAL(10,2),
    room_type VARCHAR(50),
    bed_info VARCHAR(50),
    room_size VARCHAR(50),
    room_view VARCHAR(50),
    room_status VARCHAR(50),
    room_floor VARCHAR(10),
    room_description TEXT,
    room_capacity VARCHAR(10),
    room_image VARCHAR(255),
    room_rating DECIMAL(2,1),
    room_review TEXT,
    room_amenities TEXT,
    room_services TEXT,
    room_facilities TEXT,
    room_policies TEXT,
    room_cancellation_policies TEXT,
    room_check_in TIME,
    room_check_out TIME
);

-- Insert 20 sample records
INSERT INTO room_entity (room_number, price, room_type, bed_info, room_size, room_view, room_status, room_floor, room_description, 
                   room_capacity, room_image, room_rating, room_review, room_amenities, room_services, room_facilities, 
                   room_policies, room_cancellation_policies, room_check_in, room_check_out)
VALUES 
('101', 50.00, 'Single', 'Queen', '25m²', 'Sea View', 'Available', '1', 'Cozy single room with modern decor', '1', 'img101.jpg', 4.5, 'Great room with a nice view', 'WiFi, TV, Air Conditioning', 'Room Service, Laundry', 'Gym, Pool', 'No smoking', 'Free cancellation within 24 hours', '14:00', '11:00'),
('102', 75.00, 'Double', 'King', '30m²', 'City View', 'Available', '2', 'Spacious room with comfortable bed', '2', 'img102.jpg', 4.7, 'Very clean and spacious', 'WiFi, TV, Mini Fridge', '24/7 Room Service', 'Spa, Parking', 'Pets allowed', 'Non-refundable', '15:00', '12:00'),
('103', 120.00, 'Suite', 'King', '50m²', 'Garden View', 'Booked', '3', 'Luxury suite with separate living area', '3', 'img103.jpg', 5.0, 'Excellent luxury experience', 'WiFi, TV, Hot Tub', 'Personal Butler', 'Sauna, Bar', 'ID required at check-in', 'Full refund before 48 hours', '13:00', '12:00'),
('104', 150.00, 'Deluxe', 'King', '40m²', 'Ocean View', 'Available', '4', 'Premium room with oceanfront balcony', '2', 'img104.jpg', 4.8, 'Loved the view!', 'WiFi, Smart TV, Bathrobe', 'Daily Housekeeping', 'Infinity Pool, Gym', 'No outside food', 'No refund after booking', '14:00', '11:30'),
('105', 50.00, 'Single', 'Twin', '22m²', 'Courtyard View', 'Booked', '1', 'Budget-friendly option', '1', 'img105.jpg', 4.3, 'Good for solo travelers', 'WiFi, TV', 'Room Cleaning', 'Common Lounge', 'Quiet hours 10 PM - 6 AM', 'Free cancellation 48 hrs', '15:00', '10:00'),
('106', 75.00, 'Double', 'Queen', '28m²', 'Mountain View', 'Available', '2', 'Comfortable room with a great view', '2', 'img106.jpg', 4.6, 'Nice ambiance', 'WiFi, Heater', 'Laundry Service', 'Sauna, Jacuzzi', 'No smoking', 'Non-refundable', '14:30', '11:30'),
('107', 120.00, 'Suite', 'King', '55m²', 'Sea View', 'Available', '5', 'Exclusive suite with luxury amenities', '3', 'img107.jpg', 5.0, 'Top-notch experience', 'WiFi, Netflix', 'Free Breakfast', 'Business Lounge', 'Guests allowed', 'Full refund within 12 hrs', '12:00', '10:00'),
('108', 150.00, 'Deluxe', 'King', '42m²', 'City Skyline', 'Available', '6', 'Perfect for business travelers', '2', 'img108.jpg', 4.9, 'Worth every penny!', 'WiFi, Work Desk', '24hr Concierge', 'Executive Lounge', 'Early check-in available', 'Cancellation charges apply', '14:00', '12:00'),
('109', 50.00, 'Single', 'Single', '20m²', 'No View', 'Available', '1', 'Basic room with essential amenities', '1', 'img109.jpg', 4.0, 'Good for short stays', 'WiFi, Fan', 'Housekeeping', 'None', 'No parties allowed', 'Free cancellation 24 hrs', '16:00', '10:30'),
('110', 75.00, 'Double', 'King', '32m²', 'Forest View', 'Booked', '3', 'Nature-inspired room', '2', 'img110.jpg', 4.7, 'Loved the peaceful setting', 'WiFi, Air Conditioning', 'Daily Cleaning', 'Hiking Trails', 'Eco-friendly policies', 'Non-refundable', '15:00', '11:00'),
('111', 90.00, 'Superior', 'Queen', '35m²', 'Lake View', 'Available', '4', 'Modern room with a peaceful setting', '2', 'img111.jpg', 4.6, 'Nice lakefront stay', 'WiFi, TV', 'Airport Shuttle', 'Private Dock', 'No smoking', 'Refundable 24 hrs before', '14:00', '11:00'),
('112', 180.00, 'Presidential Suite', 'King', '70m²', 'Penthouse View', 'Available', '7', 'Ultimate luxury stay', '4', 'img112.jpg', 5.0, 'Unparalleled experience!', 'Private Bar, Butler', 'Personal Chauffeur', 'Helipad Access', 'Security Deposit Required', 'No refund', '13:00', '12:30'),
('113', 55.00, 'Single', 'Single', '23m²', 'Alley View', 'Booked', '1', 'Small but cozy', '1', 'img113.jpg', 4.2, 'Good budget option', 'WiFi, Heater', 'Daily Cleaning', 'No Parking', 'No pets', 'Fully refundable', '16:00', '10:30'),
('114', 130.00, 'Executive Suite', 'King', '50m²', 'Beachfront', 'Available', '6', 'Designed for corporate travelers', '3', 'img114.jpg', 4.9, 'Best for business stays', 'WiFi, Work Desk, Espresso Machine', 'Meeting Room Access', 'VIP Lounge', 'Early check-in available', 'Cancellation fee applies', '13:00', '11:30'),
('115', 65.00, 'Double', 'Twin', '28m²', 'River View', 'Available', '2', 'Comfortable room with twin beds', '2', 'img115.jpg', 4.5, 'Nice and clean', 'WiFi, Netflix', 'Laundry', 'Public Transport Nearby', 'Guests allowed', 'Refundable within 48 hrs', '15:00', '11:00');

-- (Add more records as needed)
