//
//        $("document").ready
//        (
//            function ()
//            {
//                CreateNewLikeButton("http://www.yahoo.com")
//
//                $("a#ChangeToGoogle").click
//                (
//                    function (e)
//                    {
//                        e.preventDefault();
//                        CreateNewLikeButton("http://www.google.ca")
//                    }
//                );
//
//            }
//        );
//
//        function CreateNewLikeButton(url)
//        {
//            var elem = $(document.createElement("fb:like"));
//            elem.attr("href", url);
//            $("div#Container").empty().append(elem);
//            FB.XFBML.parse($("div#Container").get(0));
//        }
