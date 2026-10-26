# VS Code AI and Agents: Feature List

Source: [Build with AI in VS Code](https://code.visualstudio.com/docs/agents/overview)  
Retrieved October 22, 2026. The URL provided (`/docsagents/overview`) returns 404; the current documentation is at `/docs/agents/overview`.

## AI assistance by task

- **Ask questions and understand code** — get explanations grounded in the current codebase and discuss alternative approaches in [Chat](https://code.visualstudio.com/docs/chat/chat-overview).
- **Plan before changing code** — ask an agent to propose an approach or use the [planning workflow](https://code.visualstudio.com/docs/agents/run/planning).
- **Make focused edits** — request an editor-local change through [inline chat](https://code.visualstudio.com/docs/chat/inline-chat).
- **Get suggestions while typing** — use [inline suggestions](https://code.visualstudio.com/docs/editing/ai-powered-suggestions) for completions and suggested next edits.
- **Run common development actions** — use [smart actions](https://code.visualstudio.com/docs/editing/copilot-smart-actions), including explaining selected code and generating commit messages.
- **Implement features, fix bugs, and refactor across files** — delegate a task to an agent that can inspect context, edit code, and run checks.
- **Choose the right level of autonomy** — compare suggestions, focused edits, questions, planning, and agents in the [AI features cheat sheet](https://code.visualstudio.com/docs/agents/reference/ai-features-cheat-sheet).

## Agent workflow and task sessions

- **Agent loop** — an agent gathers context, reasons about the task, uses tools, and validates work; the user can provide more context, redirect, or stop it. Learn [how agents work](https://code.visualstudio.com/docs/agents/concepts/agents).
- **Context gathering** — agents can use relevant code, errors, and test results rather than relying only on the prompt. See [agent context](https://code.visualstudio.com/docs/agents/concepts/context).
- **Tool use** — agents act on the development environment through tools. See [agent tools](https://code.visualstudio.com/docs/agents/concepts/tools).
- **Sessions** — keep related conversation and task work together, return to tasks, and manage independent work through [sessions](https://code.visualstudio.com/docs/agents/concepts/sessions).
- **End-to-end workflow** — follow the guide to [run agents in VS Code](https://code.visualstudio.com/docs/agents/run/overview), from the first request through steering, review, and recovery.

## Ways to use agents

- **Chat view** — work alongside an open project, keep the conversation by the editor, inspect changes, and use the terminal, tests, and debugger in the same workflow. See [Chat view](https://code.visualstudio.com/docs/agents/run/chat-view).
- **Agents window** — assign work, manage sessions across projects, monitor progress, and open the editor to work directly with code. See the [Agents window](https://code.visualstudio.com/docs/agents/run/agents-window).
- **Continue supported sessions across interfaces** — move between the Chat view and Agents window and discover supported sessions from the CLI or Copilot app. See [session management](https://code.visualstudio.com/docs/agents/run/sessions/manage-sessions).
- **Terminal workflow** — use [GitHub Copilot CLI](https://code.visualstudio.com/docs/agents/run/sessions/manage-sessions#_use-copilot-cli-from-the-terminal) and resume supported sessions in the terminal.
- **Desktop workflow** — use the [GitHub Copilot app](https://github.com/features/copilot) and open or continue supported local sessions in VS Code.
- **Cloud delegation** — delegate work to [cloud agents](https://code.visualstudio.com/docs/agents/run/agent-harnesses#_start-a-cloud-session) that can return pull requests.
- **Remote work** — use [remote agent sessions and browser access](https://code.visualstudio.com/docs/agents/run/remote-agent-sessions).
- **Accessible interaction** — use the [Accessible View and other accessibility features](https://code.visualstudio.com/docs/configure/accessibility/accessibility#_accessible-view).

## Models, harnesses, and customization

- **Choose a model** — select a [language model](https://code.visualstudio.com/docs/agents/concepts/language-models) based on the reasoning capability, speed, and cost needed.
- **Choose an agent harness** — use [supported harnesses](https://code.visualstudio.com/docs/agents/run/agent-harnesses), including Copilot, Anthropic Claude, and OpenAI Codex; a harness connects a model to tools and manages a session. See [harness concepts](https://code.visualstudio.com/docs/agents/concepts/agent-harnesses).
- **Configure model access** — use models from a Copilot plan, [bring your own model key](https://code.visualstudio.com/docs/agent-customization/language-models#_bring-your-own-language-model-key), or connect a supported local model.
- **Provide project-specific guidance** — share coding standards and test commands through [project instructions](https://code.visualstudio.com/docs/agents/guides/customize-copilot-guide).
- **Connect external systems** — add tools and integrations through [Model Context Protocol (MCP) servers](https://code.visualstudio.com/docs/agent-customization/mcp-servers).
- **Package reusable workflows** — create [agent skills](https://code.visualstudio.com/docs/agent-customization/agent-skills) for recurring tasks.
- **Bundle tools and workflows** — install [agent plugins](https://code.visualstudio.com/docs/agent-customization/agent-plugins).
- **Compare customization approaches** — see [agent customization concepts](https://code.visualstudio.com/docs/agents/concepts/customization).
- **Choose where processing runs** — model hosting and tool execution location are separate choices; for example, local file edits can use a hosted model. Availability depends on the harness, account, and organization policies. See [harness requirements and setup](https://code.visualstudio.com/docs/agents/run/agent-harnesses#_requirements-and-setup).

## Review, permissions, and safety

- **Review and validate edits** — inspect the diff and test results before integrating changes with [code edit review](https://code.visualstudio.com/docs/agents/run/review-code-edits).
- **Control agent actions** — configure [permissions and approvals](https://code.visualstudio.com/docs/agents/run/approvals) to require confirmation for actions.
- **Steer or stop work** — send messages while a request is running or stop it through [Chat](https://code.visualstudio.com/docs/chat/chat-overview#_send-messages-while-a-request-is-running). Stopping does not undo completed changes or external actions.
- **Isolate work** — use Git worktrees to keep code changes separate; note that a worktree is not a security boundary. See [agent sandboxing](https://code.visualstudio.com/docs/agents/run/agent-sandboxing) for platform-specific file-system and network restrictions.
- **Establish a security baseline** — review the [recommended security baseline](https://code.visualstudio.com/docs/agents/run/security#_recommended-security-baseline) before using agents in an existing project.
- **Apply organization policy** — managed environments can restrict agents, models, and tools through [enterprise AI policies](https://code.visualstudio.com/docs/enterprise/manage-ai-settings).
- **Troubleshoot agent availability** — see the [agents FAQ](https://code.visualstudio.com/docs/agents/agent-troubleshooting/faq#_agents-are-not-available-in-chat) if agents do not appear in Chat.

## Getting started

- [Install VS Code and open a workspace](https://code.visualstudio.com/docs/getstarted/overview).
- [Complete the agents quickstart](https://code.visualstudio.com/docs/agents/quickstart).
- Follow the [experienced-agent fast track](https://code.visualstudio.com/docs/agents/guides/overview#_experienced-agent-fast-track) to start in an existing repository.
- Review the [Copilot setup guide](https://code.visualstudio.com/docs/setup/copilot) for account, usage, and data-handling requirements.
- [Adapt agents to a project](https://code.visualstudio.com/docs/agents/guides/customize-copilot-guide) and [optimize quality, reliability, and usage](https://code.visualstudio.com/docs/agents/guides/optimize-usage).
