CREATE VIEW "producer_winner"
AS
SELECT
       ROW_NUMBER() OVER () AS  "id",
       "pw"."movie_id",
       "pw"."producer_id",
       LAG("pw"."movie_year") OVER (PARTITION BY "pw"."producer_id" ORDER BY "pw"."movie_year") AS "previous_win",
       "pw"."movie_year" as "following_win",
       "movie_year" - LAG("pw"."movie_year") OVER (PARTITION BY "pw"."producer_id" ORDER BY "pw"."movie_year") AS "interval"
FROM
(
    SELECT "m"."year" AS "movie_year",
           "m"."id" AS "movie_id",
           "mp"."producers_id" AS "producer_id"
    FROM "movie_producers" "mp"
       INNER JOIN "movie" "m"
            ON "m"."id" = "mp"."movie_id"
    WHERE "m"."winner" = true
) "pw"