delete from season_periods;
insert into season_periods (season, period_start, period_end) values ( 'SPRING', '2024-04-01', '2024-06-30' );
insert into season_periods (season, period_start, period_end) values ( 'SUMMER', '2024-07-01', '2024-10-31' );
insert into season_periods (season, period_start, period_end) values ( 'AUTUMN', '2024-11-01', '2024-12-31' );
insert into season_periods (season, period_start, period_end) values ( 'WINTER', '2025-01-01', '2025-03-31' );

delete from farms;
insert into farms (farm_name) values ('Farm A');
insert into farms (farm_name) values ('Farm B');
insert into farms (farm_name) values ('Farm C');

delete from products;
insert into products (product_name) values ( 'Corn' );
insert into products (product_name) values ( 'Potato' );

delete from planted_products;
insert into planted_products (area, farm_id, product_id, season_period_id, date_planted, expected_amount ) values ( 1000, 1, 1, 1, '2024-02-01', 200);
insert into planted_products (area, farm_id, product_id, season_period_id, date_planted, expected_amount ) values ( 1000, 2, 1, 1, '2024-02-01', 200);
insert into planted_products (area, farm_id, product_id, season_period_id, date_planted, expected_amount ) values ( 1000, 1, 2, 3, '2024-09-01', 200);

delete from harvested_products;
insert into harvested_products (farm_id, product_id, season_period_id, date_harvested, harvested_amount ) values ( 1, 1, 1, '2024-04-01', 250);
insert into harvested_products (farm_id, product_id, season_period_id, date_harvested, harvested_amount ) values ( 2, 1, 1, '2024-08-01', 3050);
insert into harvested_products (farm_id, product_id, season_period_id, date_harvested, harvested_amount ) values ( 1, 2, 3, '2024-08-01', 520);