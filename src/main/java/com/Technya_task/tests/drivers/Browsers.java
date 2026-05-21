package com.Techneya_task.tests.drivers;

public enum Browsers {
    CHROME {
        @Override
        public AbstractDriver getDriverfactory() {
            return new ChromeFactory();
        }

    };

    public abstract AbstractDriver getDriverfactory();

}
