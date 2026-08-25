# P-Todo 

---

## English

A lightweight, high-performance desktop todo application for individuals and small teams, built with modern JavaFX.

**Platform:** Windows | **Tech Stack:** Java 25 + JavaFX 26 + SQLite | **License:** MIT

### Features

- **Task Management** — Create, edit, complete, delete tasks with rich metadata (priority, due date, assignee, tags)
- **Color Priority System** — 4-tier color coding: Gray (None) → Green (Low) → Yellow (Medium) → Red (High/Urgent)
- **Mini Window** — Always-on-top compact floating widget, no taskbar icon, drag-to-move, resizable
- **Multi-View Dashboard** — List, Kanban Board, Calendar (with Lunar Calendar), Statistics, Dashboard
- **9-Language i18n** — 中文, 繁體中文, English, 日本語, 조선어, Français, Deutsch, Español, Português
- **REST API** — 18 endpoints on port 9527 for full CRUD, search, statistics, export, settings
- **Notification Sound** — Sound alerts for due and overdue tasks, customizable audio files

### Quick Start

**Requirements:** Java 25+ (JDK), Maven 3.9+

```bash
mvn compile
mvn package -DskipTests
java --module-path "target/classes;PATH_TO_JAVAFX/lib" \
  --add-modules javafx.controls,javafx.fxml,javafx.swing \
  --add-opens com.teamtodo/com.teamtodo.dao=ALL-UNNAMED \
  --add-opens com.teamtodo/com.teamtodo.model=ALL-UNNAMED \
  -cp target/classes com.teamtodo.App
```

Or use the included scripts: `compile.bat` / `compile.ps1` (compile), `run_app.bat` (run), `run_debug.bat` (debug).

### Project Structure

```
team-todo/
├── src/main/java/com/teamtodo/
│   ├── App.java                    # Entry point
│   ├── api/ApiServer.java          # REST API (port 9527)
│   ├── controller/                 # JavaFX controllers (10 files)
│   ├── dao/                        # SQLite data access (5 files)
│   ├── model/                      # Data models + enums
│   ├── service/                    # Business logic (6 files)
│   ├── sync/                       # Server sync
│   └── util/                       # Utilities (i18n, calendar, export, etc.)
├── src/main/resources/
│   ├── css/style.css               # UI theme
│   ├── fxml/                       # 5 FXML layouts
│   ├── i18n/                       # 9 language files
│   └── icon.png                    # App icon
├── tools/                          # i18n helper scripts
├── pom.xml                         # Maven config
├── README.md                       # This file
├── LICENSE                         # MIT License
└── 说明.md                          # Full documentation (Chinese)
```

### REST API Reference

**Base URL:** `http://localhost:9527`

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/health` | Health check |
| GET | `/api/todos` | List all todos |
| GET | `/api/todos/{id}` | Get single todo |
| POST | `/api/todos` | Create todo |
| PUT | `/api/todos/{id}` | Update todo |
| DELETE | `/api/todos/{id}` | Delete todo |
| POST | `/api/todos/{id}/complete` | Toggle completion |
| GET | `/api/todos/{id}/comments` | Get comments |
| POST | `/api/todos/{id}/comments` | Add comment |
| DELETE | `/api/comments/{id}` | Delete comment |
| GET | `/api/users` | List users |
| POST | `/api/users` | Create user |
| PUT | `/api/users/{id}` | Update user |
| DELETE | `/api/users/{id}` | Delete user |
| GET | `/api/stats` | Statistics |
| GET | `/api/search?q=` | Search todos |
| GET/POST | `/api/settings/language` | Language setting |
| POST | `/api/export` | Export data (JSON/CSV) |

### Known Issues

- IME candidate window does not follow cursor position (JavaFX 26 known issue)
- High-DPI display may have drag offset on mini window

### Documentation

- [Full Documentation (说明.md)](说明.md) — Architecture, i18n guide, extension guide
- [REST API Skill (SKILL.md)](SKILL.md) — For AI agent integration

### License

[MIT](LICENSE) — Copyright (c) 2026 **Pondsi**

---

## 繁體中文

輕量、高效能的桌面待辦事項管理應用程式，專為個人和小型團隊設計，採用現代 JavaFX 構建。

**平台：** Windows | **技術棧：** Java 25 + JavaFX 26 + SQLite | **授權條款：** MIT

### 主要功能

- **待辦管理** — 建立、編輯、完成、刪除任務，支援豐富的中繼資料（優先順序、截止日期、負責人、標籤）
- **顏色優先順序系統** — 四級色彩編碼：灰色（無）→ 綠色（低）→ 黃色（中）→ 紅色（高/緊急）
- **迷你視窗** — 永遠置頂的緊湊浮動小工具，不在工作列顯示圖示，可拖曳移動、調整大小
- **多視圖儀表板** — 清單、看板、日曆（含農曆）、統計、儀表板
- **9 語言國際化** — 中文、繁體中文、English、日本語、조선어、Français、Deutsch、Español、Português
- **REST API** — 18 個端點，連接埠 9527，完整 CRUD、搜尋、統計、匯出、設定
- **通知音效** — 逾期和到期任務的聲音提醒，可自訂音訊檔案

### 快速開始

**系統需求：** Java 25+（JDK）、Maven 3.9+

```bash
mvn compile
mvn package -DskipTests
java --module-path "target/classes;PATH_TO_JAVAFX/lib" \
  --add-modules javafx.controls,javafx.fxml,javafx.swing \
  --add-opens com.teamtodo/com.teamtodo.dao=ALL-UNNAMED \
  --add-opens com.teamtodo/com.teamtodo.model=ALL-UNNAMED \
  -cp target/classes com.teamtodo.App
```

或使用內建腳本：`compile.bat` / `compile.ps1`（編譯）、`run_app.bat`（執行）、`run_debug.bat`（偵錯）。

### 專案結構

```
team-todo/
├── src/main/java/com/teamtodo/
│   ├── App.java                    # 入口點
│   ├── api/ApiServer.java          # REST API（連接埠 9527）
│   ├── controller/                 # JavaFX 控制器（10 個檔案）
│   ├── dao/                        # SQLite 資料存取（5 個檔案）
│   ├── model/                      # 資料模型 + 列舉
│   ├── service/                    # 業務邏輯（6 個檔案）
│   ├── sync/                       # 伺服器同步
│   └── util/                       # 工具類（國際化、日曆、匯出等）
├── src/main/resources/
│   ├── css/style.css               # UI 主題
│   ├── fxml/                       # 5 個 FXML 佈局
│   ├── i18n/                       # 9 種語言檔案
│   └── icon.png                    # 應用圖示
├── tools/                          # 國際化輔助腳本
├── pom.xml                         # Maven 設定
├── README.md                       # 本檔案
├── LICENSE                         # MIT 授權條款
└── 说明.md                          # 完整中文文件
```

### REST API 參考

**基礎 URL：** `http://localhost:9527`

| 方法 | 端點 | 說明 |
|------|------|------|
| GET | `/api/health` | 健康檢查 |
| GET | `/api/todos` | 取得所有待辦 |
| GET | `/api/todos/{id}` | 取得單個待辦 |
| POST | `/api/todos` | 建立待辦 |
| PUT | `/api/todos/{id}` | 更新待辦 |
| DELETE | `/api/todos/{id}` | 刪除待辦 |
| POST | `/api/todos/{id}/complete` | 切換完成狀態 |
| GET | `/api/todos/{id}/comments` | 取得評論 |
| POST | `/api/todos/{id}/comments` | 新增評論 |
| DELETE | `/api/comments/{id}` | 刪除評論 |
| GET | `/api/users` | 取得使用者 |
| POST | `/api/users` | 建立使用者 |
| PUT | `/api/users/{id}` | 更新使用者 |
| DELETE | `/api/users/{id}` | 刪除使用者 |
| GET | `/api/stats` | 統計資料 |
| GET | `/api/search?q=` | 搜尋待辦 |
| GET/POST | `/api/settings/language` | 語言設定 |
| POST | `/api/export` | 匯出資料（JSON/CSV） |

### 已知問題

- IME 候選視窗不跟隨游標位置（JavaFX 26 已知問題）
- 高 DPI 顯示器上迷你視窗拖曳可能有偏移

### 授權條款

[MIT](LICENSE) — Copyright (c) 2026 **Pondsi**

---

## 日本語

軽量・高性能なデスクトップ用タスク管理アプリケーション。個人〜小規模チーム向けにモダンな JavaFX で構築。

**プラットフォーム：** Windows | **技術スタック：** Java 25 + JavaFX 26 + SQLite | **ライセンス：** MIT

### 主な機能

- **タスク管理** — 作成、編集、完了、削除、担当者指定。優先度、期限、タグなどの豊富なメタデータをサポート
- **カラー優先度システム** — 4段階カラーコーディング：グレー（なし）→ 緑（低）→ 黄（中）→ 赤（高/緊急）
- **ミニウィンドウ** — 常に最前面のコンパクトなフローティングウィジェット。タスクバーにアイコン非表示、ドラッグ移動、リサイズ可能
- **マルチビューダッシュボード** — リスト、カンバン、カレンダー（旧暦対応）、統計、ダッシュボード
- **9言語国際化** — 中文、繁體中文、English、日本語、조선어、Français、Deutsch、Español、Português
- **REST API** — ポート9527で18エンドポイント。完全なCRUD、検索、統計、エクスポート、設定
- **通知音** — 期限到達・超過タスクのサウンドアラート、カスタマイズ可能

### クイックスタート

**前提条件：** Java 25+（JDK）、Maven 3.9+

```bash
mvn compile
mvn package -DskipTests
java --module-path "target/classes;PATH_TO_JAVAFX/lib" \
  --add-modules javafx.controls,javafx.fxml,javafx.swing \
  --add-opens com.teamtodo/com.teamtodo.dao=ALL-UNNAMED \
  --add-opens com.teamtodo/com.teamtodo.model=ALL-UNNAMED \
  -cp target/classes com.teamtodo.App
```

または内蔵スクリプトを使用：`compile.bat` / `compile.ps1`（コンパイル）、`run_app.bat`（実行）、`run_debug.bat`（デバッグ）。

### プロジェクト構造

```
team-todo/
├── src/main/java/com/teamtodo/
│   ├── App.java                    # エントリポイント
│   ├── api/ApiServer.java          # REST API（ポート9527）
│   ├── controller/                 # JavaFXコントローラー（10ファイル）
│   ├── dao/                        # SQLiteデータアクセス（5ファイル）
│   ├── model/                      # データモデル + 列挙型
│   ├── service/                    # ビジネスロジック（6ファイル）
│   ├── sync/                       # サーバー同期
│   └── util/                       # ユーティリティ（i18n、カレンダー、エクスポート等）
├── src/main/resources/
│   ├── css/style.css               # UIテーマ
│   ├── fxml/                       # FXMLレイアウト（5ファイル）
│   ├── i18n/                       # 9言語ファイル
│   └── icon.png                    # アプリアイコン
├── tools/                          # i18nヘルパースクリプト
├── pom.xml                         # Maven設定
├── README.md                       # 本ファイル
├── LICENSE                         # MITライセンス
└── 说明.md                          # 完全な説明書（中文）
```

### REST APIリファレンス

**ベースURL：** `http://localhost:9527`

| メソッド | エンドポイント | 説明 |
|----------|----------------|------|
| GET | `/api/health` | ヘルスチェック |
| GET | `/api/todos` | 全タスク取得 |
| GET | `/api/todos/{id}` | 単一タスク取得 |
| POST | `/api/todos` | タスク作成 |
| PUT | `/api/todos/{id}` | タスク更新 |
| DELETE | `/api/todos/{id}` | タスク削除 |
| POST | `/api/todos/{id}/complete` | 完了状態切替 |
| GET | `/api/todos/{id}/comments` | コメント取得 |
| POST | `/api/todos/{id}/comments` | コメント追加 |
| DELETE | `/api/comments/{id}` | コメント削除 |
| GET | `/api/users` | ユーザー一覧 |
| POST | `/api/users` | ユーザー作成 |
| PUT | `/api/users/{id}` | ユーザー更新 |
| DELETE | `/api/users/{id}` | ユーザー削除 |
| GET | `/api/stats` | 統計データ |
| GET | `/api/search?q=` | タスク検索 |
| GET/POST | `/api/settings/language` | 言語設定 |
| POST | `/api/export` | データエクスポート（JSON/CSV） |

### 既知の問題

- IME候補ウィンドウがカーソルに追従しない（JavaFX 26の既知バグ）
- 高DPI表示でミニウィンドウのドラッグにオフセットが発生

### ライセンス

[MIT](LICENSE) — Copyright (c) 2026 **Pondsi**

---

## 조선어

경량·고성능 데스크톱 할일 관리 앱. 개인 및 소규모 팀을 위해 모던 JavaFX로 구축.

**플랫폼:** Windows | **기술 스택:** Java 25 + JavaFX 26 + SQLite | **라이선스:** MIT

### 주요 기능

- **할일 관리** — 생성, 편집, 완료, 삭제. 우선순위, 마감일, 담당자, 태그 등 풍부한 메타데이터 지원
- **색상 우선순위 시스템** — 4단계 색상 코딩: 회색(없음) → 녹색(낮음) → 노란색(보통) → 빨간색(높음/긴급)
- **미니 창** — 항상 최상위의 컴팩트한 플로팅 위젯. 작업 표시줄 아이콘 없음, 드래그 이동, 크기 조절 가능
- **다중 뷰 대시보드** — 목록, 칸반 보드, 달력(음력 포함), 통계, 대시보드
- **9개 언어 국제화** — 中文, 繁體中文, English, 日本語, 조선어, Français, Deutsch, Español, Português
- **REST API** — 포트 9527에 18개 엔드포인트. 완전한 CRUD, 검색, 통계, 내보내기, 설정
- **알림 소리** — 마감 및 기한 초과 작업에 대한 사운드 알림, 사용자 지정 가능

### 빠른 시작

**필수 조건:** Java 25+ (JDK), Maven 3.9+

```bash
mvn compile
mvn package -DskipTests
java --module-path "target/classes;PATH_TO_JAVAFX/lib" \
  --add-modules javafx.controls,javafx.fxml,javafx.swing \
  --add-opens com.teamtodo/com.teamtodo.dao=ALL-UNNAMED \
  --add-opens com.teamtodo/com.teamtodo.model=ALL-UNNAMED \
  -cp target/classes com.teamtodo.App
```

또는 내장 스크립트 사용: `compile.bat` / `compile.ps1` (컴파일), `run_app.bat` (실행), `run_debug.bat` (디버그).

### 프로젝트 구조

```
team-todo/
├── src/main/java/com/teamtodo/
│   ├── App.java                    # 진입점
│   ├── api/ApiServer.java          # REST API (포트 9527)
│   ├── controller/                 # JavaFX 컨트롤러 (10개 파일)
│   ├── dao/                        # SQLite 데이터 액세스 (5개 파일)
│   ├── model/                      # 데이터 모델 + 열거형
│   ├── service/                    # 비즈니스 로직 (6개 파일)
│   ├── sync/                       # 서버 동기화
│   └── util/                       # 유틸리티 (다국어, 달력, 내보내기 등)
├── src/main/resources/
│   ├── css/style.css               # UI 테마
│   ├── fxml/                       # FXML 레이아웃 (5개 파일)
│   ├── i18n/                       # 9개 언어 파일
│   └── icon.png                    # 앱 아이콘
├── tools/                          # 다국어 도움말 스크립트
├── pom.xml                         # Maven 설정
├── README.md                       # 이 파일
├── LICENSE                         # MIT 라이선스
└── 说明.md                          # 전체 문서 (중국어)
```

### REST API 참조

**기본 URL:** `http://localhost:9527`

| 메서드 | 엔드포인트 | 설명 |
|--------|-----------|------|
| GET | `/api/health` | 상태 확인 |
| GET | `/api/todos` | 모든 할일 목록 |
| GET | `/api/todos/{id}` | 단일 할일 조회 |
| POST | `/api/todos` | 할일 생성 |
| PUT | `/api/todos/{id}` | 할일 수정 |
| DELETE | `/api/todos/{id}` | 할일 삭제 |
| POST | `/api/todos/{id}/complete` | 완료 상태 전환 |
| GET | `/api/todos/{id}/comments` | 댓글 조회 |
| POST | `/api/todos/{id}/comments` | 댓글 추가 |
| DELETE | `/api/comments/{id}` | 댓글 삭제 |
| GET | `/api/users` | 사용자 목록 |
| POST | `/api/users` | 사용자 생성 |
| PUT | `/api/users/{id}` | 사용자 수정 |
| DELETE | `/api/users/{id}` | 사용자 삭제 |
| GET | `/api/stats` | 통계 |
| GET | `/api/search?q=` | 할일 검색 |
| GET/POST | `/api/settings/language` | 언어 설정 |
| POST | `/api/export` | 데이터 내보내기 (JSON/CSV) |

### 알려진 문제

- IME 후보 창이 커서를 따라가지 않음 (JavaFX 26 알려진 버그)
- 고DPI 디스플레이에서 미니 창 드래그 오프셋 발생 가능

### 라이선스

[MIT](LICENSE) — Copyright (c) 2026 **Pondsi**

---

## Français

Application légère et performante de gestion de tâches de bureau, conçue pour les particuliers et les petites équipes avec JavaFX moderne.

**Plateforme :** Windows | **Stack technique :** Java 25 + JavaFX 26 + SQLite | **Licence :** MIT

### Fonctionnalités

- **Gestion des tâches** — Créer, modifier, compléter, supprimer des tâches avec des métadonnées riches (priorité, date limite, assignataire, tags)
- **Système de couleurs** — Codage couleur à 4 niveaux : Gris (Aucun) → Vert (Faible) → Jaune (Moyen) → Rouge (Élevé/Urgent)
- **Mini fenêtre** — Widget flottant compact toujours au premier plan, pas d'icône dans la barre des tâches, déplaçable, redimensionnable
- **Tableau de bord multi-vues** — Liste, tableau Kanban, calendrier (avec calendrier lunaire), statistiques, tableau de bord
- **Internationalisation 9 langues** — 中文, 繁體中文, English, 日本語,조선어, Français, Deutsch, Español, Português
- **REST API** — 18 points de terminaison sur le port 9527, CRUD complet, recherche, statistiques, exportation, paramètres
- **Son de notification** — Alertes sonores pour les tâches à échéance et en retard, fichiers audio personnalisables

### Démarrage rapide

**Prérequis :** Java 25+ (JDK), Maven 3.9+

```bash
mvn compile
mvn package -DskipTests
java --module-path "target/classes;PATH_TO_JAVAFX/lib" \
  --add-modules javafx.controls,javafx.fxml,javafx.swing \
  --add-opens com.teamtodo/com.teamtodo.dao=ALL-UNNAMED \
  --add-opens com.teamtodo/com.teamtodo.model=ALL-UNNAMED \
  -cp target/classes com.teamtodo.App
```

Ou utilisez les scripts inclus : `compile.bat` / `compile.ps1` (compiler), `run_app.bat` (exécuter), `run_debug.bat` (déboguer).

### Structure du projet

```
team-todo/
├── src/main/java/com/teamtodo/
│   ├── App.java                    # Point d'entrée
│   ├── api/ApiServer.java          # REST API (port 9527)
│   ├── controller/                 # Contrôleurs JavaFX (10 fichiers)
│   ├── dao/                        # Accès données SQLite (5 fichiers)
│   ├── model/                      # Modèles de données + énumérations
│   ├── service/                    # Logique métier (6 fichiers)
│   ├── sync/                       # Synchronisation serveur
│   └── util/                       # Utilitaires (i18n, calendrier, export, etc.)
├── src/main/resources/
│   ├── css/style.css               # Thème UI
│   ├── fxml/                       # 5 layouts FXML
│   ├── i18n/                       # 9 fichiers de langue
│   └── icon.png                    # Icône de l'application
├── tools/                          # Scripts d'aide i18n
├── pom.xml                         # Configuration Maven
├── README.md                       # Ce fichier
├── LICENSE                         # Licence MIT
└── 说明.md                          # Documentation complète (chinois)
```

### Référence REST API

**URL de base :** `http://localhost:9527`

| Méthode | Point de terminaison | Description |
|---------|---------------------|-------------|
| GET | `/api/health` | Vérification de santé |
| GET | `/api/todos` | Lister toutes les tâches |
| GET | `/api/todos/{id}` | Obtenir une tâche |
| POST | `/api/todos` | Créer une tâche |
| PUT | `/api/todos/{id}` | Modifier une tâche |
| DELETE | `/api/todos/{id}` | Supprimer une tâche |
| POST | `/api/todos/{id}/complete` | Basculer l'achèvement |
| GET | `/api/todos/{id}/comments` | Obtenir les commentaires |
| POST | `/api/todos/{id}/comments` | Ajouter un commentaire |
| DELETE | `/api/comments/{id}` | Supprimer un commentaire |
| GET | `/api/users` | Lister les utilisateurs |
| POST | `/api/users` | Créer un utilisateur |
| PUT | `/api/users/{id}` | Modifier un utilisateur |
| DELETE | `/api/users/{id}` | Supprimer un utilisateur |
| GET | `/api/stats` | Statistiques |
| GET | `/api/search?q=` | Rechercher des tâches |
| GET/POST | `/api/settings/language` | Paramètre de langue |
| POST | `/api/export` | Exporter les données (JSON/CSV) |

### Problèmes connus

- La fenêtre de candidat IME ne suit pas le curseur (bug connu de JavaFX 26)
- Décalage de glissement possible sur les écrans haute DPI

### Licence

[MIT](LICENSE) — Copyright (c) 2026 **Pondsi**

---

## Deutsch

Leichtgewichtige, leistungsstarke Desktop-ToDo-Anwendung für Einzelpersonen und kleine Teams, gebaut mit modernem JavaFX.

**Plattform:** Windows | **Tech-Stack:** Java 25 + JavaFX 26 + SQLite | **Lizenz:** MIT

### Funktionen

- **Aufgabenverwaltung** — Erstellen, Bearbeiten, Abschließen, Löschen mit reichhaltigen Metadaten (Priorität, Fälligkeit, Zuständiger, Tags)
- **Farbsystem** — 4-Stufen-Farbcodierung: Grau (Keine) → Grün (Niedrig) → Gelb (Mittel) → Rot (Hoch/Dringend)
- **Mini-Fenster** — Kompaktes, immer im Vordergrund schwebendes Widget, kein Taskleistensymbol, verschiebbar, skalierbar
- **Mehransichten-Dashboard** — Liste, Kanban-Board, Kalender (mit Mondkalender), Statistiken, Dashboard
- **9-Sprachen-i18n** — 中文, 繁體中文, English, 日本語, 조선어, Français, Deutsch, Español, Português
- **REST API** — 18 Endpunkte auf Port 9527, vollständiges CRUD, Suche, Statistiken, Export, Einstellungen
- **Benachrichtigungston** — Soundalarme für fällige und überfällige Aufgaben, anpassbare Audiodateien

### Schnellstart

**Voraussetzungen:** Java 25+ (JDK), Maven 3.9+

```bash
mvn compile
mvn package -DskipTests
java --module-path "target/classes;PATH_TO_JAVAFX/lib" \
  --add-modules javafx.controls,javafx.fxml,javafx.swing \
  --add-opens com.teamtodo/com.teamtodo.dao=ALL-UNNAMED \
  --add-opens com.teamtodo/com.teamtodo.model=ALL-UNNAMED \
  -cp target/classes com.teamtodo.App
```

Oder verwenden Sie die mitgelieferten Skripte: `compile.bat` / `compile.ps1` (kompilieren), `run_app.bat` (ausführen), `run_debug.bat` (debuggen).

### Projektstruktur

```
team-todo/
├── src/main/java/com/teamtodo/
│   ├── App.java                    # Einstiegspunkt
│   ├── api/ApiServer.java          # REST API (Port 9527)
│   ├── controller/                 # JavaFX-Controller (10 Dateien)
│   ├── dao/                        # SQLite-Datenzugriff (5 Dateien)
│   ├── model/                      # Datenmodelle + Enums
│   ├── service/                    // Geschäftslogik (6 Dateien)
│   ├── sync/                       # Server-Synchronisation
│   └── util/                       # Hilfsprogramme (i18n, Kalender, Export, etc.)
├── src/main/resources/
│   ├── css/style.css               # UI-Design
│   ├── fxml/                       # 5 FXML-Layouts
│   ├── i18n/                       # 9 Sprachdateien
│   └── icon.png                    # App-Symbol
├── tools/                          # i18n-Hilfsskripte
├── pom.xml                         # Maven-Konfiguration
├── README.md                       # Diese Datei
├── LICENSE                         # MIT-Lizenz
└── 说明.md                          # Vollständige Dokumentation (Chinesisch)
```

### REST-API-Referenz

**Basis-URL:** `http://localhost:9527`

| Methode | Endpunkt | Beschreibung |
|---------|----------|--------------|
| GET | `/api/health` | Gesundheitsprüfung |
| GET | `/api/todos` | Alle Aufgaben auflisten |
| GET | `/api/todos/{id}` | Einzelne Aufgabe abrufen |
| POST | `/api/todos` | Aufgabe erstellen |
| PUT | `/api/todos/{id}` | Aufgabe bearbeiten |
| DELETE | `/api/todos/{id}` | Aufgabe löschen |
| POST | `/api/todos/{id}/complete` | Abschluss umschalten |
| GET | `/api/todos/{id}/comments` | Kommentare abrufen |
| POST | `/api/todos/{id}/comments` | Kommentar hinzufügen |
| DELETE | `/api/comments/{id}` | Kommentar löschen |
| GET | `/api/users` | Benutzer auflisten |
| POST | `/api/users` | Benutzer erstellen |
| PUT | `/api/users/{id}` | Benutzer bearbeiten |
| DELETE | `/api/users/{id}` | Benutzer löschen |
| GET | `/api/stats` | Statistiken |
| GET | `/api/search?q=` | Aufgaben suchen |
| GET/POST | `/api/settings/language` | Spracheinstellung |
| POST | `/api/export` | Daten exportieren (JSON/CSV) |

### Bekannte Probleme

- IME-Kandidatenfenster folgt dem Cursor nicht (bekannter JavaFX 26-Bug)
- Verschiebungsoffset des Mini-Fensters auf High-DPI-Displays möglich

### Lizenz

[MIT](LICENSE) — Copyright (c) 2026 **Pondsi**

---

## Español

Herramienta de gestión de tareas de escritorio ligera y de alto rendimiento para individuos y pequeños equipos, construida con JavaFX moderno.

**Plataforma:** Windows | **Stack tecnológico:** Java 25 + JavaFX 26 + SQLite | **Licencia:** MIT

### Características

- **Gestión de tareas** — Crear, editar, completar, eliminar con metadatos completos (prioridad, fecha límite, responsable, etiquetas)
- **Sistema de colores** — Codificación por colores de 4 niveles: Gris (Ninguno) → Verde (Bajo) → Amarillo (Medio) → Rojo (Alto/Urgente)
- **Mini ventana** — Widget flotante compacto siempre visible, sin icono en la barra de tareas, arrastrable, redimensionable
- **Panel multi-vista** — Lista, tablero Kanban, calendario (con calendario lunar), estadísticas, panel
- **i18n de 9 idiomas** — 中文, 繁體中文, English, 日本語, 조선어, Français, Deutsch, Español, Português
- **REST API** — 18 endpoints en el puerto 9527, CRUD completo, búsqueda, estadísticas, exportación, configuración
- **Sonido de notificación** — Alertas sonoras para tareas vencidas y atrasadas, archivos de audio personalizables

### Inicio rápido

**Requisitos:** Java 25+ (JDK), Maven 3.9+

```bash
mvn compile
mvn package -DskipTests
java --module-path "target/classes;PATH_TO_JAVAFX/lib" \
  --add-modules javafx.controls,javafx.fxml,javafx.swing \
  --add-opens com.teamtodo/com.teamtodo.dao=ALL-UNNAMED \
  --add-opens com.teamtodo/com.teamtodo.model=ALL-UNNAMED \
  -cp target/classes com.teamtodo.App
```

O use los scripts incluidos: `compile.bat` / `compile.ps1` (compilar), `run_app.bat` (ejecutar), `run_debug.bat` (depurar).

### Estructura del proyecto

```
team-todo/
├── src/main/java/com/teamtodo/
│   ├── App.java                    # Punto de entrada
│   ├── api/ApiServer.java          # REST API (puerto 9527)
│   ├── controller/                 # Controladores JavaFX (10 archivos)
│   ├── dao/                        # Acceso a datos SQLite (5 archivos)
│   ├── model/                      # Modelos de datos + enumeraciones
│   ├── service/                    # Lógica de negocio (6 archivos)
│   ├── sync/                       # Sincronización con servidor
│   └── util/                       # Utilidades (i18n, calendario, exportación, etc.)
├── src/main/resources/
│   ├── css/style.css               # Tema de interfaz
│   ├── fxml/                       # 5 diseños FXML
│   ├── i18n/                       # 9 archivos de idioma
│   └── icon.png                    # Icono de la aplicación
├── tools/                          # Scripts auxiliares de i18n
├── pom.xml                         # Configuración de Maven
├── README.md                       # Este archivo
├── LICENSE                         # Licencia MIT
└── 说明.md                          # Documentación completa (chino)
```

### Referencia REST API

**URL base:** `http://localhost:9527`

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/health` | Verificación de salud |
| GET | `/api/todos` | Listar todas las tareas |
| GET | `/api/todos/{id}` | Obtener una tarea |
| POST | `/api/todos` | Crear tarea |
| PUT | `/api/todos/{id}` | Actualizar tarea |
| DELETE | `/api/todos/{id}` | Eliminar tarea |
| POST | `/api/todos/{id}/complete` | Alternar finalización |
| GET | `/api/todos/{id}/comments` | Obtener comentarios |
| POST | `/api/todos/{id}/comments` | Añadir comentario |
| DELETE | `/api/comments/{id}` | Eliminar comentario |
| GET | `/api/users` | Listar usuarios |
| POST | `/api/users` | Crear usuario |
| PUT | `/api/users/{id}` | Actualizar usuario |
| DELETE | `/api/users/{id}` | Eliminar usuario |
| GET | `/api/stats` | Estadísticas |
| GET | `/api/search?q=` | Buscar tareas |
| GET/POST | `/api/settings/language` | Configuración de idioma |
| POST | `/api/export` | Exportar datos (JSON/CSV) |

### Problemas conocidos

- La ventana de candidatos IME no sigue al cursor (error conocido de JavaFX 26)
- Desplazamiento al arrastrar mini ventana en pantallas de alta DPI

### Licencia

[MIT](LICENSE) — Copyright (c) 2026 **Pondsi**

---

## Português

Ferramenta de gerenciamento de tarefas de desktop leve e de alto desempenho para indivíduos e pequenas equipes, construída com JavaFX moderno.

**Plataforma:** Windows | **Stack:** Java 25 + JavaFX 26 + SQLite | **Licença:** MIT

### Funcionalidades

- **Gerenciamento de tarefas** — Criar, editar, concluir, excluir com metadados completos (prioridade, data limite, responsável, tags)
- **Sistema de cores** — Codificação por cores de 4 níveis: Cinza (Nenhum) → Verde (Baixo) → Amarelo (Médio) → Vermelho (Alto/Urgente)
- **Mini janela** — Widget flutuante compacto sempre no topo, sem ícone na barra de tarefas, arrastável, redimensionável
- **Painel multi-visualização** — Lista, quadro Kanban, calendário (com calendário lunar), estatísticas, painel
- **i18n de 9 idiomas** — 中文, 繁體中文, English, 日本語, 조선어, Français, Deutsch, Español, Português
- **REST API** — 18 endpoints na porta 9527, CRUD completo, pesquisa, estatísticas, exportação, configurações
- **Som de notificação** — Alertas sonoros para tarefas vencidas e atrasadas, arquivos de áudio personalizáveis

### Início rápido

**Pré-requisitos:** Java 25+ (JDK), Maven 3.9+

```bash
mvn compile
mvn package -DskipTests
java --module-path "target/classes;PATH_TO_JAVAFX/lib" \
  --add-modules javafx.controls,javafx.fxml,javafx.swing \
  --add-opens com.teamtodo/com.teamtodo.dao=ALL-UNNAMED \
  --add-opens com.teamtodo/com.teamtodo.model=ALL-UNNAMED \
  -cp target/classes com.teamtodo.App
```

Ou use os scripts inclusos: `compile.bat` / `compile.ps1` (compilar), `run_app.bat` (executar), `run_debug.bat` (depurar).

### Estrutura do projeto

```
team-todo/
├── src/main/java/com/teamtodo/
│   ├── App.java                    # Ponto de entrada
│   ├── api/ApiServer.java          # REST API (porta 9527)
│   ├── controller/                 # Controladores JavaFX (10 arquivos)
│   ├── dao/                        # Acesso a dados SQLite (5 arquivos)
│   ├── model/                      # Modelos de dados + enumerações
│   ├── service/                    # Lógica de negócio (6 arquivos)
│   ├── sync/                       # Sincronização com servidor
│   └── util/                       # Utilidades (i18n, calendário, exportação, etc.)
├── src/main/resources/
│   ├── css/style.css               # Tema da interface
│   ├── fxml/                       # 5 layouts FXML
│   ├── i18n/                       # 9 arquivos de idioma
│   └── icon.png                    # Ícone do aplicativo
├── tools/                          # Scripts auxiliares de i18n
├── pom.xml                         # Configuração do Maven
├── README.md                       # Este arquivo
├── LICENSE                         # Licença MIT
└── 说明.md                          # Documentação completa (chinês)
```

### Referência da REST API

**URL base:** `http://localhost:9527`

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/api/health` | Verificação de saúde |
| GET | `/api/todos` | Listar todas as tarefas |
| GET | `/api/todos/{id}` | Obter uma tarefa |
| POST | `/api/todos` | Criar tarefa |
| PUT | `/api/todos/{id}` | Atualizar tarefa |
| DELETE | `/api/todos/{id}` | Excluir tarefa |
| POST | `/api/todos/{id}/complete` | Alternar conclusão |
| GET | `/api/todos/{id}/comments` | Obter comentários |
| POST | `/api/todos/{id}/comments` | Adicionar comentário |
| DELETE | `/api/comments/{id}` | Excluir comentário |
| GET | `/api/users` | Listar usuários |
| POST | `/api/users` | Criar usuário |
| PUT | `/api/users/{id}` | Atualizar usuário |
| DELETE | `/api/users/{id}` | Excluir usuário |
| GET | `/api/stats` | Estatísticas |
| GET | `/api/search?q=` | Pesquisar tarefas |
| GET/POST | `/api/settings/language` | Configuração de idioma |
| POST | `/api/export` | Exportar dados (JSON/CSV) |

### Problemas conhecidos

- A janela de candidatos IME não segue o cursor (bug conhecido do JavaFX 26)
- Deslocamento ao arrastar mini janela em telas de alta DPI

### Licença

[MIT](LICENSE) — Copyright (c) 2026 **Pondsi**
