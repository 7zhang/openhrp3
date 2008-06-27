/*
 * Copyright (c) 2008, AIST, the University of Tokyo and General Robotix Inc.
 * All rights reserved. This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * General Robotix Inc.
 * National Institute of Advanced Industrial Science and Technology (AIST) 
 */
package com.generalrobotix.ui.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageBundle {
    private static MessageBundle this_;
    protected static ResourceBundle messages_;

    private MessageBundle() {
        messages_ =
            ResourceBundle.getBundle("resources.MessageBundle", Locale.US);
    }

    private  MessageBundle(Locale locale) {
        messages_ = ResourceBundle.getBundle("resources.MessageBundle", locale);
    }

    public static final void setLocale(Locale locale) {
        if (this_ == null) {
            this_ = new MessageBundle(locale);
        } else {
            messages_ =
                ResourceBundle.getBundle("resources.MessageBundle", locale);
        }
    }

    public static final void setLocal(String language, String country) {
        if (this_ == null) {
            this_ = new MessageBundle(new Locale(language, country));
        } else {
            messages_ =
                ResourceBundle.getBundle(
                    "resources.MessageBundle",
                    new Locale(language, country)
                );
        }
    }

    public static final String get(String key) {
        if (this_ == null) {
            new MessageBundle();
        }
        return messages_.getString(key);
    }

    public static final ResourceBundle getMessages() { return messages_; }
} 
