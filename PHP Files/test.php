<?php   
$con=mysqli_connect("supply-drop.cdkcwqlnuxlm.us-west-2.rds.amazonaws.com", "kodite", "#2Twinkie", "supply-drop");

if (mysqli_connect_errno($con)) {
    echo "Failed to connect to MySQL: " . mysqli_connect_error();
}

echo "Connected successfully";

mysqli_close($con);

?>