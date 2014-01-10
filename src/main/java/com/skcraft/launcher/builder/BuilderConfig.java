/*
 * SK's Minecraft Launcher
 * Copyright (C) 2010-2014 Albert Pham <http://www.sk89q.com> and contributors
 * Please see LICENSE.txt for license information.
 */

package com.skcraft.launcher.builder;

import lombok.Data;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.emptyToNull;

@Data
public class BuilderConfig {

    private String name;
    private String title;
    private String gameVersion;
    private List<FeaturePattern> features;
    private FnPatternList userFiles;

    public void registerProperties(PropertiesApplicator applicator) {
        if (features != null) {
            for (FeaturePattern feature : features) {
                checkNotNull(emptyToNull(feature.getFeature().getName()),
                        "Empty feature name found");
                applicator.register(feature);
            }
        }

        applicator.setUserFiles(userFiles);
    }

}
