package com.duzhaokun123.bilibilihd.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.PreferenceManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Set;

import master.flame.danmaku.danmaku.model.IDisplayer;

public class Settings {
    private static LoginUserInfoMap loginUserInfoMap;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private static boolean inited = false;
    private static SharedPreferences sharedPreferences2;

    private static final int INT = 0;
    private static final int FLOAT = 1;
    private static final int STRING = 2;
    private static final int BOOLEAN = 3;
    private static final int STRING_SET = 4;

    private static final String TAG = "SettingsManager";

    public static boolean isUninited() {
        return !inited;
    }

    @SuppressLint("CommitPrefEdits")
    public static void init(Context context) {
        Settings.sharedPreferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE);
        Settings.editor = sharedPreferences.edit();

        Settings.firstStart = sharedPreferences.getBoolean("firstStart", true);

        Settings.sharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        Settings.inited = true;
    }

    public static final Layout layout = new Layout();
    public static final Download download = new Download();
    public static final Danmaku danmaku = new Danmaku();
    public static final Ads ads = new Ads();

    public static LoginUserInfoMap getLoginUserInfoMap(Context context) {
        if (loginUserInfoMap == null) {
            File file = new File(context.getFilesDir(), "LoginUserInfoMap");
            if (file.exists()) {
                FileInputStream fileInputStream = null;
                ObjectInputStream objectInputStream = null;
                try {
                    fileInputStream = new FileInputStream(file);
                    objectInputStream = new ObjectInputStream(fileInputStream);
                    loginUserInfoMap = (LoginUserInfoMap) objectInputStream.readObject();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                    loginUserInfoMap = new LoginUserInfoMap();
                } finally {
                    try {
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                loginUserInfoMap = new LoginUserInfoMap();
            }
        }
        return loginUserInfoMap;
    }

    public static void saveLoginUserInfoMap(Context context) {
        if (loginUserInfoMap != null) {
            File file = new File(context.getFilesDir(), "LoginUserInfoMap");
            FileOutputStream fileOutputStream = null;
            ObjectOutputStream objectOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(file);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(loginUserInfoMap);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void save(String key, int type, Object value) {
        if (editor == null) {
            Log.e(TAG, "editor is null, settings cannot be saved");
        } else {
            switch (type) {
                case INT:
                    editor.putInt(key, Integer.parseInt(value.toString()));
                    break;
                case FLOAT:
                    editor.putFloat(key, Float.parseFloat(value.toString()));
                    break;
                case BOOLEAN:
                    editor.putBoolean(key, Boolean.parseBoolean(value.toString()));
                    break;
                case STRING:
                    editor.putString(key, (String) value);
                    break;
                case STRING_SET:
                    editor.putStringSet(key, (Set<String>) value);
                    break;
                default:
                    Log.wtf(TAG, type + " is not defined");
                    break;
            }
            editor.apply();
        }
    }

    private static boolean firstStart = true;

    public static boolean isFirstStart() {
        return firstStart;
    }

    public static void setFirstStart(boolean firstStart) {
        Settings.firstStart = firstStart;
        save("firstStart", BOOLEAN, firstStart);
    }

    public static class Layout {

        public int getColumn() {
            String column = sharedPreferences2.getString("column", "0");
            try {
                if (column != null) {
                    return Integer.parseInt(column);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }

        public void setColumn(int column) {
            throw new RuntimeException("stub");
        }

        public int getColumnLand() {
            String columnLand = sharedPreferences2.getString("column_land", "0");
            try {
                if (columnLand != null) {
                    return Integer.parseInt(columnLand);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }

        public void setColumnLand(int columnLand) {
            throw new RuntimeException("stub");
        }

        public int getUiMode() {
            String uiMod = sharedPreferences2.getString("ui_mod", "0");
            if ("2".equals(uiMod)) {
                return AppCompatDelegate.MODE_NIGHT_YES;
            } else if ("1".equals(uiMod)) {
                return AppCompatDelegate.MODE_NIGHT_NO;
            } else {
                return AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM;
            }
        }

        public void setUiMode(int uiMode) {
            throw new RuntimeException("stub");
        }
    }

    public static class Download {
        public static final int DOWNLOAD_MANAGER = 1;
        public static final int GLIDE_CACHE_FIRST = 2;

        public int getDownloader() {
            String downloader = sharedPreferences2.getString("downloader", "0");
            if ("1".equals(downloader)) {
                return DOWNLOAD_MANAGER;
            } else {
                return GLIDE_CACHE_FIRST;
            }
        }

        public void setDownloader(int downloader) {
            throw new RuntimeException("stub");
        }

    }

    public static class Danmaku {
        public int getDanmakuStyle() {
            String style = sharedPreferences2.getString("danmaku_style", "1");
            try {
                if (style != null) {
                    return Integer.parseInt(style);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 1;
        }

        public boolean isDuplicateMerging() {
            return sharedPreferences2.getBoolean("duplicate_merging", false);
        }

        public float getTextSize() {
            String size = sharedPreferences2.getString("text_size", "0");
            try {
                if (size != null) {
                    return Float.parseFloat(size);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return 0;
        }

        public int getDanmakuMargin() {
            String margin = sharedPreferences2.getString("DanmakuMargin", "0");
            try {
                if (margin != null) {
                    return Integer.parseInt(margin);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return 0;
        }

        public float getP1() {
            String p = sharedPreferences2.getString("danmaku_style_p1", "0.5");
            try {
                if (p != null) {
                    return Float.parseFloat(p);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return 0.5f;
        }

        public float getP2() {
            String p = sharedPreferences2.getString("danmaku_style_p2", "0");
            try {
                if (p != null) {
                    return Float.parseFloat(p);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return 0f;
        }

        public float getP3() {
            String p = sharedPreferences2.getString("danmaku_style_p3", "0");
            try {
                if (p != null) {
                    return Float.parseFloat(p);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return 0f;
        }

        public float getScrollSpeedFactor() {
            String f = sharedPreferences2.getString("danmaku_scroll_speed_factor", "1.2");

            try {
                if (!"0".equals(f) && f != null) {
                    return Float.parseFloat(f);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return 1.2f;
        }
    }

    public static class Ads {
        public boolean isShowWelcomeAd() {
            return sharedPreferences2.getBoolean("welcome_ads", true);
        }
    }
}
