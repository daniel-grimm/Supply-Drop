<?php

/*
This query returns all of a user's requests.
*/

	mysql_connect("supply-drop.cdkcwqlnuxlm.us-west-2.rds.amazonaws.com", "kodite", "#2Twinkie");
	mysql_select_db(supply-drop);

	$q=mysql_query("<query>");
	while($e=mysql_fetch_assoc($q))
		$output[]=$e;

	print(json_encode($output));

	mysql_close();
?>