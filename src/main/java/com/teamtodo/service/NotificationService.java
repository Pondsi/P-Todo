package com.teamtodo.service;

import com.teamtodo.util.I18n;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import static com.teamtodo.util.I18n.t;

/**
 * 通知服务 - 系统提示音
 */
public class NotificationService {
    private static final Logger log = LoggerFactory.getLogger(NotificationService.class);
    private static NotificationService instance;
    private String customSoundPath;

    public enum SoundType {
        COMPLETE("status.done"), WARNING("common.warning"), ERROR("common.error"), INFO("common.info"), REMINDER("reminder.title");
        private final String labelKey;
        SoundType(String labelKey) { this.labelKey = labelKey; }
        public String getLabel() { return I18n.t(labelKey); }
    }

    private NotificationService() {}

    public static synchronized NotificationService getInstance() {
        if (instance == null) instance = new NotificationService();
        return instance;
    }

    public void playSound(SoundType type) {
        try {
            // 使用系统蜂鸣音
            java.awt.Toolkit.getDefaultToolkit().beep();
            log.debug("播放提示音: {}", type.getLabel());
        } catch (Exception e) {
            log.warn("播放提示音失败", e);
        }
    }

    public void setCustomSoundPath(String path) {
        this.customSoundPath = path;
        log.info("自定义音效路径: {}", path);
    }

    public String getCustomSoundPath() { return customSoundPath; }

    public void testSound() { playSound(SoundType.INFO); }
}
