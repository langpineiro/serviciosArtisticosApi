package com.serviciosArtisticos.servicios.Utils;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonParams {
        private int page;
        private int size;

        public CommonParams() {
            this.page = 0;
            this.size = 10;
        }
}
