use  test;
CREATE VIEW image_info AS
    SELECT 
        a.id,
        a.title,
        a.description,
        a.url,
        SUM(CASE
            WHEN b.liked = 1 THEN 1
            ELSE 0
        END) AS total_likes,
        SUM(CASE
            WHEN b.shared = 1 THEN 1
            ELSE 0
        END) AS total_shares
    FROM
        image a
            LEFT JOIN
        user_image b ON b.image_id = a.id
    GROUP BY a.id;