$(document).ready(function(){
	$("#jquery_jplayer_2").jPlayer({ 
        ready: function () { 
            $(this).jPlayer("setMedia", { 
                m4v: "media/tokyo.m4v", 
                ogv: "media/tokyo.ogv", 
                poster: "media/poster.jpg" 
            }); 
        }, 
        ended: function (event) { 
            $("#jquery_jplayer_2").jPlayer("play", 0); 
        }, 
        swfPath: "js", 
        supplied: "m4v, ogv", 
        cssSelectorAncestor: "#jp_interface_2" 
    }) 
    .bind($.jPlayer.event.play, function() { // pause other instances of player when current one play 
            $(this).jPlayer("pauseOthers"); 
    }); 
});