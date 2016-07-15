(function(){
    (function($, document, window){
        var pluginName, Plugin, defaults, Timeout;
        pluginName = "jmenu";
        defaults = {
            during : 100,
			panel_selector : "panel-selector"
        };
        Plugin = (function(){
            function Plugin(elements, options){
                this.elements = elements;
                this.options = $.extend(true, {},defaults, options);
                
                this.init();
            }
            return Plugin;
        })();
        
        Plugin.prototype.init = function(){
			var $element,panel_selector,_this;
			_this = this;
			$element = $(this.elements);
			panel_selector = this.options.panel_selector;
			Timeout.during = this.options.during;
            $element.mouseover(function(){
				_this._mouseover(_this);
			});
			$element.mouseout(function(){
				_this._mouseout(_this);
			});
			$(this.options.panel_selector).mouseover(function(){
				_this._mouseover(_this);
			});
			$(panel_selector).mouseout(function(){
				_this._mouseout(_this);
			});
			
        }
        
		Plugin.prototype._mouseover = function(obj){
			var panel_selector = obj.options.panel_selector;
			Timeout.stop();
            Timeout.begin(function(){
				$(panel_selector).css("display","");	
			});
			
		}
		
		Plugin.prototype._mouseout = function(obj){
			var panel_selector = obj.options.panel_selector;
			Timeout.stop();
			Timeout.begin(function(){
				$(panel_selector).css("display","none");		
			});
			
		}
		
		
        Timeout = {
            status : 0,
            handle : null,
            during : undefined,
            begin : function(fn){
                
                if(Timeout.status == 0){
                    
                    Timeout.handle = setTimeout(function(){
                        fn(arguments[1], arguments[2]);
                    },Timeout.during);
                    Timeout.status = 1;
                }
            },
            stop : function(){
                if(Timeout.status == 1){
                    clearTimeout(Timeout.handle);
                    Timeout.handle = null;
                    Timeout.status = 0;
                }
                
            }
        }
        
        return $.fn[pluginName] = function(options){
            return this.each(function(){
                if(!$.data(this, "plugin_" + pluginName)){
                    $.data(this, "plugin_" + pluginName, new Plugin(this, options));
                }
                
            });
            
        }
    })(jQuery, document, window);
    
}).call(this);