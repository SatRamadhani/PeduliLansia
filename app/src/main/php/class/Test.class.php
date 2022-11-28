<?php

class Test extends DB
{
    // Get default data.
    function get_data()
    {
        $response = [];
        $response['status'] = 0;
        $response['message'] = "Connected to the database.";

        return $response;
    }
}

?>