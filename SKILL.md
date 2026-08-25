# TeamTodo REST API Skill
# TeamTodo REST API スキル
# TeamTodo Compétence API REST
# TeamTodo REST API 스킬
# TeamTodo REST-API-Skill
# TeamTodo Habilidad API REST
# TeamTodo Habilidade API REST

> **Use this skill when users need to interact with the TeamTodo todo application.**
> **ユーザーがTeamTodo待办アプリと操作する際に使用してください。**
> **Utilisez cette compétence lorsque les utilisateurs ont besoin d'interagir avec l'application de tâches TeamTodo.**
> **사용자가 TeamTodo 할일 앱과 상호작용해야 할 때 이 스킬을 사용하세요.**
> **Verwenden Sie dieses Skill, wenn Benutzer mit der TeamTodo-ToDo-Anwendung interagieren müssen.**
> **Use esta habilidad cuando los usuarios necesiten interactuar con la aplicación de tareas TeamTodo.**
> **Use esta habilidade quando os usuários precisarem interagir com o aplicativo de tarefas TeamTodo.**

**Triggers:** 待办, 任务, TeamTodo, todo, task, タスク, 作業, tâche, 할일, Aufgabe, tarea, tarefa
**触发词:** 待办, 任务, TeamTodo, todo, task, タスク, 作業, tâche, 할일, Aufgabe, tarea, tarefa

---

## Prerequisites / 前提条件 / Prérequis / 필수 조건 / Voraussetzungen / Requisitos previos / Pré-requisitos

1. **TeamTodo is running** — app must be launched (port 9527)
   1. **TeamTodoが起動中** — アプリが起動している必要があります（ポート9527）
   1. **TeamTodo est en cours d'exécution** — l'application doit être lancée (port 9527)
   1. **TeamTodo 실행 중** — 앱이 실행되어 있어야 합니다 (포트 9527)
   1. **TeamTodo läuft** — Die Anwendung muss gestartet sein (Port 9527)
   1. **TeamTodo está ejecutándose** — la aplicación debe estar iniciada (puerto 9527)
   1. **TeamTodo está em execução** — o aplicativo deve ser iniciado (porta 9527)

2. **Health check** — verify service is ready
   2. **ヘルスチェック** — サービスの準備状態を確認
   2. **Vérification de santé** — vérifier que le service est prêt
   2. **상태 확인** — 서비스 준비 상태 확인
   2. **Gesundheitsprüfung** — überprüfen, ob der Dienst bereit ist
   2. **Verificación de salud** — verificar que el servicio está listo
   2. **Verificação de saúde** — verificar se o serviço está pronto

```bash
curl http://localhost:9527/api/health
```

---

## API Endpoints / API エンドポイント / Points de terminaison API / API 엔드포인트 / API-Endpunkte / Puntos de extremo API / Pontos de extremidade API

### Health Check / ヘルスチェック / Vérification de santé / 상태 확인 / Gesundheitsprüfung / Verificación de salud / Verificação de saúde

```http
GET /api/health
```

### Todo Management / タスク管理 / Gestion des tâches / 할일 관리 / Aufgabenverwaltung / Gestión de tareas / Gerenciamento de tarefas

```http
GET    /api/todos              List all todos / 全待办一覧 / Lister toutes les tâches / 모든 할일 목록
GET    /api/todos/{id}         Get single todo / 单个待办取得 / Obtenir une tâche / 단일 할일 조회
POST   /api/todos              Create todo / 待办を作成 / Créer une tâche / 할일 생성
PUT    /api/todos/{id}         Update todo / 待办を更新 / Modifier une tâche / 할일 수정
DELETE /api/todos/{id}         Delete todo / 待办を削除 / Supprimer une tâche / 할일 삭제
POST   /api/todos/{id}/complete Toggle completion / 完了状態切替 / Basculer l'achèvement / 완료 상태 전환
```

**Create Todo Body / 作成リクエストボディ / Corps de création / 생성 요청 본문:**
```json
{
  "title": "string",
  "description": "string (optional)",
  "priority": "LOW | MEDIUM | HIGH | URGENT",
  "assignee_id": "string (optional)",
  "due_date": "YYYY-MM-DD (optional)",
  "tags": ["string"] (optional)
}
```

### Comments / コメント / Commentaires / 댓글 / Kommentare / Comentarios / Comentários

```http
GET    /api/todos/{id}/comments  Get comments / コメント取得 / Obtenir les commentaires / 댓글 조회
POST   /api/todos/{id}/comments  Add comment / コメント追加 / Ajouter un commentaire / 댓글 추가
DELETE /api/comments/{id}        Delete comment / コメント削除 / Supprimer un commentaire / 댓글 삭제
```

**Add Comment Body / コメント追加ボディ / Corps d'ajout / 댓글 추가 본문:**
```json
{
  "user_id": "string",
  "content": "string"
}
```

### User Management / ユーザー管理 / Gestion des utilisateurs / 사용자 관리 / Benutzerverwaltung / Gestión de usuarios / Gerenciamento de usuários

```http
GET    /api/users              List users / ユーザー一覧 / Lister les utilisateurs / 사용자 목록
POST   /api/users              Create user / ユーザー作成 / Créer un utilisateur / 사용자 생성
PUT    /api/users/{id}         Update user / ユーザー更新 / Modifier un utilisateur / 사용자 수정
DELETE /api/users/{id}         Delete user / ユーザー削除 / Supprimer un utilisateur / 사용자 삭제
```

### Statistics / 統計 / Statistiques / 통계 / Statistiken / Estadísticas / Estatísticas

```http
GET    /api/stats              Get statistics / 統計取得 / Obtenir les statistiques / 통계 조회
```

### Search / 検索 / Recherche / 검색 / Suche / Búsqueda / Pesquisa

```http
GET    /api/search?q=keyword   Search todos / 待办検索 / Rechercher des tâches / 할일 검색
```

### Settings / 設定 / Paramètres / 설정 / Einstellungen / Configuración / Configurações

```http
GET    /api/settings/sound     Get sound path / 音效パス取得 / Obtenir le chemin du son / 사운드 경로 조회
POST   /api/settings/sound     Set sound path / 音效パス設定 / Définir le chemin du son / 사운드 경로 설정
GET    /api/settings/language  Get language / 言語取得 / Obtenir la langue / 언어 조회
POST   /api/settings/language  Set language / 言語設定 / Définir la langue / 언어 설정
```

**Set Language Body / 言語設定ボディ / Corps de langue / 언어 설정 본문:**
```json
{
  "language": "zh | zh-TW | en | ja | ko | fr | de | es | pt"
}
```

### Export / エクスポート / Exportation / 내보내기 / Export / Exportación / Exportação

```http
POST   /api/export             Export data / データ出力 / Exporter les données / 데이터 내보내기
```

**Export Body / エクスポートボディ / Corps d'export / 내보내기 본문:**
```json
{
  "format": "json | csv",
  "path": "string (optional, defaults to ~/team-todo/export/)"
}
```

---

## Priority Values / 優先度の値 / Valeurs de priorité / 우선순위 값 / Prioritätswerte / Valores de prioridad / Valores de prioridade

| Value | Meaning | 意味 | Signification | 의미 | Bedeutung | Significado | Significado |
|-------|---------|------|---------------|------|-----------|-------------|-------------|
| `LOW` | Low priority | 低 | Faible | 낮음 | Niedrig | Bajo | Baixo |
| `MEDIUM` | Medium priority | 中 | Moyen | 보통 | Mittel | Medio | Médio |
| `HIGH` | High priority | 高 | Élevé | 높음 | Hoch | Alto | Alto |
| `URGENT` | Urgent / Overdue | 紧急 | Urgent | 긴급 | Dringend | Urgente | Urgente |

---

## Response Format / レスポンス形式 / Format de réponse / 응답 형식 / Antwortformat / Formato de respuesta / Formato de resposta

All endpoints return JSON. Successful responses use the structure:
全エンドポイントはJSONを返します。成功レスポンスの構造：
Tous les points de terminaison renvoient JSON. Structure des réponses réussies :
모든 엔드포인트는 JSON을 반환합니다. 성공 응답 구조 :
Alle Endpunkte geben JSON zurück. Struktur erfolgreicher Antworten :
Todos los endpoints devuelven JSON. Estructura de respuestas exitosas :
Todos os endpoints retornam JSON. Estrutura de respostas bem-sucedidas :

```json
{
  "success": true,
  "data": { ... }
}
```

Error responses:
エラーレスポンス：
Réponses d'erreur :
오류 응답：
Fehlerantworten：
Respuestas de error：
Respostas de erro：

```json
{
  "success": false,
  "error": "error message"
}
```

---

## cURL Examples / cURL 使用例 / Exemples cURL / cURL 예시 / cURL-Beispiele / Ejemplos cURL / Exemplos cURL

```bash
# Health check / ヘルスチェック / Vérification / 상태 확인
curl http://localhost:9527/api/health

# Create todo / 待办作成 / Créer / 할일 생성
curl -X POST http://localhost:9527/api/todos \
  -H "Content-Type: application/json" \
  -d '{"title":"Buy milk","priority":"MEDIUM"}'

# List todos / 待办一覧 / Lister / 할일 목록
curl http://localhost:9527/api/todos

# Toggle complete / 完了切替 / Basculer / 완료 전환
curl -X POST http://localhost:9527/api/todos/TODO_ID/complete

# Search / 検索 / Rechercher / 검색
curl "http://localhost:9527/api/search?q=milk"

# Export CSV / CSV出力 / Exporter CSV / CSV 내보내기
curl -X POST http://localhost:9527/api/export \
  -H "Content-Type: application/json" \
  -d '{"format":"csv"}'

# Switch language / 言語切替 / Changer langue / 언어 전환
curl -X POST http://localhost:9527/api/settings/language \
  -H "Content-Type: application/json" \
  -d '{"language":"ja"}'
```

---

## Notes / 注意事項 / Remarques / 참고 사항 / Hinweise / Notas / Observações

- **Port:** 9527 (configurable in Settings, requires restart)
- **ポート:** 9527（設定で変更可能、再起動が必要）
- **Port :** 9527 (configurable dans les paramètres, redémarrage requis)
- **포트:** 9527 (설정에서 변경 가능, 재시작 필요)
- **Port:** 9527 (in den Einstellungen konfigurierbar, Neustart erforderlich)
- **Puerto:** 9527 (configurable en configuración, requiere reinicio)
- **Porta:** 9527 (configurável nas configurações, requer reinicialização)

- **Database:** SQLite, located at `~/team-todo/data/team-todo.db`
- **データベース:** SQLite、`~/team-todo/data/team-todo.db`に配置
- **Base de données :** SQLite, située dans `~/team-todo/data/team-todo.db`
- **데이터베이스:** SQLite, `~/team-todo/data/team-todo.db`에 위치
- **Datenbank:** SQLite, befindet sich unter `~/team-todo/data/team-todo.db`
- **Base de datos:** SQLite, ubicada en `~/team-todo/data/team-todo.db`
- **Banco de dados:** SQLite, localizado em `~/team-todo/data/team-todo.db`

- **Logs:** `~/team-todo/data/team-todo.log`
- **ログ:** `~/team-todo/data/team-todo.log`
- **Journaux :** `~/team-todo/data/team-todo.log`
- **로그:** `~/team-todo/data/team-todo.log`
- **Logs:** `~/team-todo/data/team-todo.log`
- **Registros:** `~/team-todo/data/team-todo.log`
- **Logs:** `~/team-todo/data/team-todo.log`

- **Supported languages:** zh, zh-TW, en, ja, ko, fr, de, es, pt
- **対応言語:** zh, zh-TW, en, ja, ko, fr, de, es, pt
- **Langues supportées :** zh, zh-TW, en, ja, ko, fr, de, es, pt
- **지원 언어:** zh, zh-TW, en, ja, ko, fr, de, es, pt
- **Unterstützte Sprachen:** zh, zh-TW, en, ja, ko, fr, de, es, pt
- **Idiomas soportados:** zh, zh-TW, en, ja, ko, fr, de, es, pt
- **Idiomas suportados:** zh, zh-TW, en, ja, ko, fr, de, es, pt
