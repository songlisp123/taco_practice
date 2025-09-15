delete from Ingredient_Ref;
delete from Taco;
delete from Taco_Order;

delete from Ingredient;
insert into Ingredient (id, name, type) 
                values ('FLTO', '玉米粉薄烙饼', 'WRAP');
insert into Ingredient (id, name, type) 
                values ('COTO', '玉米薄饼', 'WRAP');
insert into Ingredient (id, name, type) 
                values ('GRBF', '牛肉', 'PROTEIN');
insert into Ingredient (id, name, type) 
                values ('CARN', '肉馅', 'PROTEIN');
insert into Ingredient (id, name, type) 
                values ('TMTO', '番茄丁', 'VEGGIES');
insert into Ingredient (id, name, type) 
                values ('LETC', '生菜', 'VEGGIES');
insert into Ingredient (id, name, type) 
                values ('CHED', '切达干酪', 'CHEESE');
insert into Ingredient (id, name, type) 
                values ('JACK', '蒙脱奶酪', 'CHEESE');
insert into Ingredient (id, name, type) 
                values ('SLSA', '沙拉酱汁', 'SAUCE');
insert into Ingredient (id, name, type) 
                values ('SRCR', '酸奶油', 'SAUCE');
