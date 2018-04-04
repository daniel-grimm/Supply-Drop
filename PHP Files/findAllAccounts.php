<?php

mysql_connect("supply-drop.cdkcwqlnuxlm.us-west-2.rds.amazonaws.com", "kodite", "#2Twinkie");
mysql_select_db(supply-drop);

$q=mysql_query("SELECT * FROM USER");
while($e=mysql_fetch_assoc($q))
	$output[]=$e;

print(json_encode($output));

mysql_close();
?>